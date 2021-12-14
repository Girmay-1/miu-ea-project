package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.RegistrationEvent;
import edu.miu.cs544.courseregistrationsystem.repository.RegistrationEventRepository;

@Service
public class RegistrationEventServiceImp implements RegistrationEventService {

	@Autowired
	RegistrationEventRepository repository;

	@Override
	public List<RegistrationEvent> getAll() {
		return this.repository.findAll();
	}

	@Override
	public RegistrationEvent get(Long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public RegistrationEvent save(RegistrationEvent registrationEvent) {
		return this.repository.save(registrationEvent);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}