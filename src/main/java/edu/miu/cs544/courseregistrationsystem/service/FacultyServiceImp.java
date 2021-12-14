package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.Faculty;
import edu.miu.cs544.courseregistrationsystem.repository.FacultyRepository;

@Service
public class FacultyServiceImp implements FacultyService{

	@Autowired
	FacultyRepository repository;

	public List<Faculty> getAllCourses() {
		return this.repository.findAll();
	}

	public Faculty readCourse(Long id) {
		return this.repository.findById(id).get();
	}

	public Faculty save(Faculty faculty) {
		return this.repository.save(faculty);
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}