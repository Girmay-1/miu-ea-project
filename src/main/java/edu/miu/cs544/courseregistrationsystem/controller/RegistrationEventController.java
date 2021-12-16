package edu.miu.cs544.courseregistrationsystem.controller;

import edu.miu.cs544.courseregistrationsystem.model.*;
import edu.miu.cs544.courseregistrationsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/registration-events")
public class RegistrationEventController {

	@Autowired
	private RegistrationEventServiceImp service;

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
	@PutMapping("/{id}")
	public ResponseEntity<?> setGroups(@PathVariable Long id, @RequestBody List<RegistrationGroup> groups) {
		RegistrationEvent event = service.get(id);
		
		if (event != null) {
			event.setRegistrationGroups(groups);
			return ResponseEntity.ok(service.save(event));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}