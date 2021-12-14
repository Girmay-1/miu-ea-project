package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import edu.miu.cs544.courseregistrationsystem.model.CourseOffering;

public interface CourseOfferingService {
	List<CourseOffering> getAll();

	CourseOffering save(CourseOffering t);

	CourseOffering get(Long id);

	void delete(Long id);
}
