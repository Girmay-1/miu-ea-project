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
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseServiceImp service;

	@GetMapping
	public ResponseEntity<List<Course>> findAll() {
		List<Course> list = service.getAll();
		if (list.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Course> get(@PathVariable Long id) {
		Course item = service.get(id);

		if (item != null) {
			return ResponseEntity.ok(item);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping("/addCourse")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		Course item = service.save(course);

		if (item != null) {
			return ResponseEntity.ok(item);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCourse(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCourse(@PathVariable Long id, @RequestBody Course course) {
		if (id.equals(course.getId())) {
			return ResponseEntity.ok(service.update(course, id));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}