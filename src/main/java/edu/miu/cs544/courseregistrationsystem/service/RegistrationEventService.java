package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.RegistrationEvent;
import edu.miu.cs544.courseregistrationsystem.repository.RegistrationEventRepository;

@Service
public class RegistrationEventService {

	@Autowired
	RegistrationEventRepository repository;

	public List<RegistrationEvent> getAllCourses() {
		return this.repository.findAll();
	}

	public RegistrationEvent readCourse(Long id) {
		return this.repository.findById(id).get();
	}

	public RegistrationEvent save(RegistrationEvent registrationEvent) {
		return this.repository.save(registrationEvent);
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}