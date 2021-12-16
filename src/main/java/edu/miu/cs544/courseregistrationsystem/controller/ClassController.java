package edu.miu.cs544.courseregistrationsystem.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.miu.cs544.courseregistrationsystem.model.*;
import edu.miu.cs544.courseregistrationsystem.model.dto.*;

import edu.miu.cs544.courseregistrationsystem.repository.CourseRepository;
import edu.miu.cs544.courseregistrationsystem.repository.RegistrationEventRepository;
import edu.miu.cs544.courseregistrationsystem.repository.RegistrationRequestRepository;


@RestController
@RequestMapping("classes")
public class ClassController {
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private RegistrationEventRepository eventRepository;

	@Autowired
	private RegistrationRequestRepository requestRepository;

	@GetMapping
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@GetMapping(path = "/event")
	public List<RegistrationEvent> event() {
		List<RegistrationEvent> events = eventRepository.currentEvent(LocalDateTime.now());
		return events;
	}

	@GetMapping(path = "/registrations")
	public ResponseEntity<List<RegistrationRequest>> registrations() {
		List<RegistrationEvent> events = eventRepository.currentEvent(LocalDateTime.now());

		RegistrationEvent currentEvent;
		if (events.isEmpty())
			return new ResponseEntity<List<RegistrationRequest>>(HttpStatus.NOT_FOUND);

		else currentEvent = events.get(0);
		Long studentId = 10L;
		
		System.out.println("------> " + currentEvent.getId() + " <----------");

		List<RegistrationRequestDto> requests = requestRepository.requests(currentEvent.getId(), studentId);
		
		return new ResponseEntity(requests, HttpStatus.OK);
	}

}
