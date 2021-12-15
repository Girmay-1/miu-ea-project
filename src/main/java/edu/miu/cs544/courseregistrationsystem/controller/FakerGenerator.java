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
import java.util.ArrayList;
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
		fakerGroupandStuds();
		fakerRegistrationEvent();
		fakerFaculty();
//		fakerAdmin();
		fakerCourseOffering();
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

	public void fakerAcademicBlock() {
		String[] blocks = { "SEPTEMBER", "OCTOBER", "NOVEMBER" };
		for (int i = 9; i < 12; i++) {
			AcademicBlock academicBlock = new AcademicBlock();
			academicBlock.setCode("2021-12A-12D");
			academicBlock.setName(blocks[i - 9] + " 2021");
			academicBlock.setStartDate(LocalDate.of(2021, i, 1));
			academicBlock.setEndDate(LocalDate.of(2021, i, 28));
			academicBlock.setSemester(Semester.WINTER);

			academicBlockService.save(academicBlock);
		}
	}

	public void fakerGroupandStuds() {
		Faker faker = new Faker();
		List<AcademicBlock> academicBlocks = academicBlockService.getAll();

		for (int i = 0; i < 3; i++) {
			RegistrationGroup group = new RegistrationGroup();
			List<Student> studs = new ArrayList<>();

			for (int j = 0; j < 10; ++j) {
				Student student = new Student();
				student.setName(faker.address().firstName());
				student.setStudentId("61-12" + j);
				student.setEmail(faker.bothify("????##@miu.edu"));
				studentService.save(student);
				studs.add(student);
			}
			group.setStudents(studs);
			group.setAcademicBlocks(academicBlocks);
			registrationGroupService.save(group);
		}
	}

	public void fakerRegistrationEvent() {
		List<RegistrationGroup> groups = registrationGroupService.getAll();
		RegistrationEvent event = new RegistrationEvent();
		event.setStartDateTime(LocalDateTime.now());
		event.setEndDateTime(LocalDateTime.now().plusDays(10));
		event.setRegistrationGroups(groups);
		registrationEventService.save(event);

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

	public void fakerCourseOffering() {
		List<Course> courses = courseService.getAll();
		List<Faculty> faculties = facultyService.getAll();
		List<AcademicBlock> academicBlocks = academicBlockService.getAll();
		List<Student> students = studentService.getAll();
//		List<RegistrationGroup> groups = registrationGroupService.getAll();
		List<CourseOffering> courseOfferings = courseOfferingService.getAll();
		int i = 0;
		for (AcademicBlock block : academicBlocks) {
			int defaultPriority = 0;
			for (Course course : courses) {
				Random r = new Random();
				int facultyRandom = r.nextInt(faculties.size());
//			int academicRandom = r.nextInt(academicBlocks.size());
//			String facultyName = "" + faculties.get(facultyRandom).getFirstName().charAt(0)
//					+ faculties.get(facultyRandom).getLastName().charAt(0);
				String courseCode = course.getCode();
				CourseOffering courseOffering = new CourseOffering();
				courseOffering
						.setCode(courseCode + "-" + block.getCode() + "-" + faculties.get(facultyRandom).getName());
				courseOffering.setFaculty(faculties.get(facultyRandom));
				courseOffering.setCourse(course);
//				courseOffering.setAcademicBlock(block);
				courseOffering.setCapacity(5);
				courseOfferingService.save(courseOffering);

				defaultPriority++;

				for (Student student : students) {
					RegistrationRequest req = new RegistrationRequest();
					req.setPriorityNumber(defaultPriority);
					req.setCourseOffering(courseOffering);
					req.setStudent(student);
//				req.setRegistrationGroups(groups);

					registrationRequestService.save(req);
				}
			}
		}
	}
}
