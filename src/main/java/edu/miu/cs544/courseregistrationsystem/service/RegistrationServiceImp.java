package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.Registration;
import edu.miu.cs544.courseregistrationsystem.repository.RegistrationRepository;

@Service
public class RegistrationServiceImp implements RegistrationService{

	@Autowired
	RegistrationRepository repository;

	public List<Registration> getAllCourses() {
		return this.repository.findAll();
	}

	public Registration readCourse(Long id) {
		return this.repository.findById(id).get();
	}

	public Registration save(Registration registration) {
		return this.repository.save(registration);
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}