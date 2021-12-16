package edu.miu.cs544.courseregistrationsystem.controller;

import edu.miu.cs544.courseregistrationsystem.model.*;
import edu.miu.cs544.courseregistrationsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/registration-events")
public class RegistrationEventController {

	@Autowired
	private RegistrationEventServiceImp service;
	
    @Autowired
    private CourseOfferingServiceImp courseOfferingService;

	@Autowired
	private AcademicBlockServiceImp blockService;

	@Autowired
	private StudentServiceImp studentService;

	@Autowired
	private RegistrationGroupServiceImp registrationGroupService;

	@Autowired
	private RegistrationRequestService registrationRequestService;

	@Autowired
	private RegistrationServiceImp registrationService;

	@GetMapping
	public ResponseEntity<List<RegistrationEvent>> findAll() {
		List<RegistrationEvent> events = service.getAll();
		if (events.isEmpty()) {
			System.out.println("No result to show!");
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(events);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RegistrationEvent> getEvent(@PathVariable Long id) {
		RegistrationEvent event = service.get(id);

		if (event != null) {
			return ResponseEntity.ok(event);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping("/addEvent")
	public ResponseEntity<RegistrationEvent> addEvent(@RequestBody RegistrationEvent registrationEvent) {
		RegistrationEvent event = service.save(registrationEvent);
		if (event != null) {
			return ResponseEntity.ok(event);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEvent(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateAnEvent(@PathVariable Long id, @RequestBody RegistrationEvent event) {
		if (id.equals(event.getId())) {
			return ResponseEntity.ok(service.update(event, id));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	// _________________________ Additional inserts _______________
	// Update a Registration Event's groups
	@PutMapping("/setgroups/{id}")
	public ResponseEntity<?> setGroups(@PathVariable Long id, @RequestBody List<RegistrationGroup> groups) {
		RegistrationEvent event = service.get(id);

		if (event != null) {
			event.setRegistrationGroups(groups);
			return ResponseEntity.ok(service.save(event));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	// Process registration requests
	@PatchMapping("/{id}/update")
	public ResponseEntity<String> processReuqest(@PathVariable long id) {
		try {
			List<RegistrationGroup> groups = registrationGroupService.findByRegistrationEvent(id);
			List<AcademicBlock> blocks = blockService.findByRegistrationGroup(groups);
//			int sumOfCapacity = 0;
//			for (AcademicBlock block : blocks) {
//				CourseOffering courseOffering = courseOfferingService.findByBlocks(block);
//				sumOfCapacity += courseOffering.getCapacity();
//			}

			System.out.println("groups -------- " + groups);
			System.out.println("blocks -------- " + blocks);

			int capacity = 0;
			for (AcademicBlock block : blocks) {
				int priority = 1;
				List<Student> students = studentService.findByRegistrationEvent(id);

				System.out.println("students -------- " + students);
				while (students.size() > 0) {
					if (priority % 2 == 0) {
						Collections.reverse(students);
					}
					for (Iterator<Student> iter = students.iterator(); iter.hasNext();) {
						Student student = iter.next();
						RegistrationRequest registrationRequest = registrationRequestService.findByAttributes(priority,
								block, student);
						if (registrationRequest != null) {
							CourseOffering courseOffering = registrationRequest.getCourseOffering();
							if (courseOffering.getCapacity() > 0) {
								Registration registration = new Registration();
								registration.setStudent(student);
								registration.setCourseOffering(courseOffering);
								registrationService.save(registration);
								courseOffering.setCapacity(courseOffering.getCapacity() - 1);
								capacity++;
								courseOfferingService.save(courseOffering);
								iter.remove();
							}
							System.out.println("Registration ---- " + students.size() + students);
						}
					}
					priority++;
				}
			}

			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}