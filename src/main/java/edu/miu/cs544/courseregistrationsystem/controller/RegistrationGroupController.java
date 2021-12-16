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
@RequestMapping("/registration-group")
public class RegistrationGroupController {

	@Autowired
	private RegistrationGroupServiceImp registrationGroupService;

	@GetMapping
	public ResponseEntity<List<RegistrationGroup>> findAll() {
		List<RegistrationGroup> groups = registrationGroupService.getAll();
		if (groups.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(groups);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RegistrationGroup> get(@PathVariable Long id) {
		RegistrationGroup group = registrationGroupService.get(id);

		if (group != null) {
			return ResponseEntity.ok(group);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	// Add 
	@PostMapping("/addGroup")
	public ResponseEntity<RegistrationGroup> addGroup(@RequestBody RegistrationGroup registrationGroup) {
		RegistrationGroup group = registrationGroupService.save(registrationGroup);

		if (group != null) {
			return ResponseEntity.ok(group);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteGroup(@PathVariable Long id) {
		registrationGroupService.delete(id);
		return ResponseEntity.noContent().build();
	}

	// _________________________ Additional inserts _______________
	// Update a Registration group's blocks
	@PutMapping("/{id}")
	public ResponseEntity<?> setBlocks(@PathVariable Long id, @RequestBody List<AcademicBlock> blocks) {
		RegistrationGroup group = registrationGroupService.get(id);
		
		if (group != null) {
			group.setAcademicBlocks(blocks);
			return ResponseEntity.ok(registrationGroupService.save(group));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}