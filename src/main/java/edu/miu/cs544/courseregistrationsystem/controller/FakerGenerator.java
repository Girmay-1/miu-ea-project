package edu.miu.cs544.courseregistrationsystem.controller;

import edu.miu.cs544.courseregistrationsystem.service.*;
import edu.miu.cs544.courseregistrationsystem.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/faker")
public class FakerGenerator {
	@Autowired
	CourseService courseService;


	@GetMapping
	public void generateFakerData() {
		fakerCourse();
	}


	public void fakerCourse() {
		String[] names = { "FPP", "MPP", "EA", "SA", "ALG", "MWA" };
		String[] codes = { "CS390", "CS400", "CS544", "CS577", "CS425", "CS572" };
		for (int i = 0; i < 6; i++) {
			Course course = new Course();
			course.setName(names[i]);
			course.setCode(codes[i]);
			course.setDescription("Sample description ... ");
			((CourseServiceImp) courseService).save(course);
		}
	}
}
