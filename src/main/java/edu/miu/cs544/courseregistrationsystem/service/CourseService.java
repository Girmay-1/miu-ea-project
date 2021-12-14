package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.Course;
import edu.miu.cs544.courseregistrationsystem.repository.CourseRepository;

@Service
public class CourseService implements ICourseService {

	@Autowired
	CourseRepository courseRepository;

	public List<Course> getAllCourses() {
		return this.courseRepository.findAll();
	}

	public Course readCourse(Long id) {
		return this.courseRepository.findById(id).get();
	}

	public Course save(Course course) {
		return this.courseRepository.save(course);
	}

	public void delete(Long id) {
		this.courseRepository.deleteById(id);
	}

}