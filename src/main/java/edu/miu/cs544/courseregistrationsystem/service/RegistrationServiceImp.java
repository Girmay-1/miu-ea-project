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

	@Override
	public List<Registration> getAll() {
		return this.repository.findAll();
	}

	@Override
	public Registration get(Long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public Registration save(Registration registration) {
		return this.repository.save(registration);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}