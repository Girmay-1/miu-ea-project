package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import edu.miu.cs544.courseregistrationsystem.model.Course;

public interface CourseService {
	List<Course> getAll();

	Course save(Course t);

	Course get(Long id);

	void delete(Long id);

}
