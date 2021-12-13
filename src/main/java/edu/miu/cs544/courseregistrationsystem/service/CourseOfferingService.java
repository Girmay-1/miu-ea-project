package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.CourseOffering;
import edu.miu.cs544.courseregistrationsystem.repository.CourseOfferingRepository;

@Service
public class CourseOfferingService {

	@Autowired
	CourseOfferingRepository repository;

	public List<CourseOffering> getAllCourses() {
		return this.repository.findAll();
	}

	public CourseOffering readCourse(Long id) {
		return this.repository.findById(id).get();
	}

	public CourseOffering save(CourseOffering courseOffering) {
		return this.repository.save(courseOffering);
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}