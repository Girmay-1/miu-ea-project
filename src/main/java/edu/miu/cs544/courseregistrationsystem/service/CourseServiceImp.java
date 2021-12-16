package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.Course;
import edu.miu.cs544.courseregistrationsystem.repository.CourseRepository;

@Service
public class CourseServiceImp implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<Course> getAll() {
		return this.courseRepository.findAll();
	}

	@Override
	public Course get(Long id) {
		return this.courseRepository.findById(id).get();
	}

	@Override
	public Course save(Course course) {
		return this.courseRepository.save(course);
	}
	
	@Override
    public Course update(Course course, Long id) {
        Course entity = (Course) get(id);
        entity.setName(course.getName());
        entity.setCode(course.getCode());
        entity.setDescription(course.getDescription());

        return courseRepository.save(entity);
    }

	@Override
	public void delete(Long id) {
		this.courseRepository.deleteById(id);
	}

}