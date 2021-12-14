package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.CourseOffering;
import edu.miu.cs544.courseregistrationsystem.repository.CourseOfferingRepository;

@Service
public class CourseOfferingServiceImp implements CourseOfferingService {

	@Autowired
	CourseOfferingRepository repository;

	@Override
	public List<CourseOffering> getAll() {
		return this.repository.findAll();
	}

	@Override
	public CourseOffering get(Long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public CourseOffering save(CourseOffering courseOffering) {
		return this.repository.save(courseOffering);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}