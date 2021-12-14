package edu.miu.cs544.courseregistrationsystem.controller;

import edu.miu.cs544.courseregistrationsystem.service.*;
import edu.miu.cs544.courseregistrationsystem.model.*;
import edu.miu.cs544.courseregistrationsystem.model.util.Semester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/faker")
public class FakerGenerator {

	@Autowired
	CourseService courseService;

	@Autowired
	AcademicBlockService academicBlockService;

	@Autowired
	StudentService studentService;

	@Autowired
	FacultyService facultyService;

//	@Autowired
//	AdminService adminService;

	@Autowired
	RegistrationEventService registrationEventService;

	@Autowired
	RegistrationRequestService registrationRequestService;

	@Autowired
	RegistrationGroupService registrationGroupService;

	@Autowired
	CourseOfferingService courseOfferingService;

	@GetMapping
	public void generateFakerData() {
		fakerCourse();
		fakerAcademicBlock();
		fakerStudent();
		fakerFaculty();
//		fakerAdmin();
		fakerRegistrationEvent();
		fakerRegistrationGroup();
//		fakerCourseOffering();
	}

	public void fakerRegistrationGroup() {
		for (int i = 0; i < 3; i++) {
			RegistrationGroup obj = new RegistrationGroup();
			registrationGroupService.save(obj);
		}
	}

	public void fakerCourse() {
		String[] names = { "FPP", "MPP", "EA", "SA", "ALG", "MWA" };
		String[] codes = { "CS390", "CS400", "CS544", "CS577", "CS425", "CS572" };
		for (int i = 0; i < 6; i++) {
			Course course = new Course();
			course.setName(names[i]);
			course.setCode(codes[i]);
			course.setDescription("Sample description ... ");
			((CourseServiceImp) courseService).save(course);
		}
	}

	public void fakerRegistrationEvent() {
		RegistrationEvent obj = new RegistrationEvent();
		obj.setStartDateTime(LocalDateTime.now());
		obj.setEndDateTime(LocalDateTime.now().plusDays(10));
		registrationEventService.save(obj);

	}

	public void fakerStudent() {
		Faker faker = new Faker();
		for (int i = 0; i < 20; ++i) {
			Student student = new Student();
			student.setName(faker.address().firstName());
			student.setStudentId("61-12" + i);
//			AcademicBlock academicBlock = new AcademicBlock();
//			academicBlock.setId(4 % i);
			student.setEmail(faker.bothify("????##@miu.edu"));
			studentService.save(student);
		}
	}

//	public void fakerAdmin() {
//		Faker faker = new Faker();
//		for (int i = 1; i < 5; i++) {
//			Admin obj = new Admin();
//			obj.setFirstName(faker.address().firstName());
//			obj.setLastName(faker.address().lastName());
//			obj.setPosition("Registrar Manager");
//			obj.setAdminId("ADM-21" + i);
//			obj.setEmail(faker.bothify("????##@gmail.com"));
//			adminService.save(obj);
//		}
//	}

	public void fakerFaculty() {

		Faker faker = new Faker();

		for (int i = 0; i < 5; ++i) {
			Faculty faculty = new Faculty();
			faculty.setName(faker.address().firstName());
			faculty.setTitle("21" + i);
			faculty.setTitle("Professor");
			faculty.setEmail(faker.bothify("????##@miu.edu"));
			facultyService.save(faculty);
		}
	}

	public void fakerAcademicBlock() {
		String[] blocks = { "SEP", "OCT", "NOV", "DEC", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL" };
//		Faker faker = new Faker();
		for (int i = 0; i < 10; i++) {
//			String code = faker.regexify("AB-" + i);
//			String name = faker.expression("EXP-");
			AcademicBlock academicBlock = new AcademicBlock();
			academicBlock.setCode("2021-12A-12D");
			academicBlock.setName(blocks[i] + " 2021");
			academicBlock.setEndDate(LocalDate.of(2021, 12, 28));
			academicBlock.setStartDate(LocalDate.of(2021, 12, 1));
			academicBlock.setSemester(Semester.WINTER);

			academicBlockService.save(academicBlock);
		}
	}

	public void fakerCourseOffering() {
		List<Course> courses = courseService.getAll();
		List<Faculty> faculties = facultyService.getAll();
		List<AcademicBlock> academicBlocks = academicBlockService.getAll();
		List<Student> students = studentService.getAll();

		int i = 0;
		for (Course course : courses) {
			Random r = new Random();
			int facultyRandom = r.nextInt(faculties.size());
			int academicRandom = r.nextInt(academicBlocks.size());
//			String facultyName = "" + faculties.get(facultyRandom).getFirstName().charAt(0)
//					+ faculties.get(facultyRandom).getLastName().charAt(0);
			String courseCode = course.getCode();
			CourseOffering courseOffering = new CourseOffering();
			courseOffering.setCode(courseCode + "-" + academicBlocks.get(academicRandom).getCode() + "-" + faculties.get(facultyRandom).getName());
			courseOffering.setFaculty(faculties.get(facultyRandom));
			courseOffering.setCourse(course);
			courseOffering.setAcademicBlock(academicBlocks.get(academicRandom));
			courseOffering.setCapacity(5);
//			List<RegistrationRequest> registReq = new ArrayList<>();
			i++;

			for (Student student : students) {
				RegistrationRequest req = new RegistrationRequest();
				req.setPriorityNumber(i);
				req.setCourseOffering(courseOffering);
				req.setStudent(student);
//				req.setStatus(Status.PENDING);

				registrationRequestService.save(req);
//				student.addRegistrationReq(req);
			}

//			courseOffering.setRegistrationsRequests(registReq);

			courseOfferingService.save(courseOffering);
		}
	}
}
