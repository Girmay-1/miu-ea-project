package edu.miu.cs544.courseregistrationsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.miu.cs544.courseregistrationsystem.model.Course;
import edu.miu.cs544.courseregistrationsystem.repository.CourseRepository;

@RestController
@RequestMapping("classes")
public class ClassController {
	@Autowired
	private CourseRepository courseRepository;

	@GetMapping
	public List<Course> findAll() {
		return courseRepository.findAll();
	}
}
