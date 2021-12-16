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
@RequestMapping("/course-offering")
public class CourseOfferingController {

	@Autowired
	private CourseOfferingServiceImp service;

	@GetMapping
	public ResponseEntity<List<CourseOffering>> findAll() {
		List<CourseOffering> list = service.getAll();
		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CourseOffering> get(@PathVariable Long id) {
		CourseOffering item = service.get(id);

		if (item != null) {
			return ResponseEntity.ok(item);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping("/addOffering")
	public ResponseEntity<CourseOffering> addOffering(@RequestBody CourseOffering courseOffering, @RequestBody Course course) {
		courseOffering.setCourse(course);
		CourseOffering item = service.save(courseOffering);

		if (item != null) {
			return ResponseEntity.ok(item);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOffering(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateOffering(@PathVariable Long id, @RequestBody CourseOffering courseOffering) {
		if (id.equals(courseOffering.getId())) {
			return ResponseEntity.ok(service.update(courseOffering, id));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}