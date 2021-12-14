package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.RegistrationRequest;
import edu.miu.cs544.courseregistrationsystem.repository.RegistrationRequestRepository;

@Service
public class RegistrationRequestServiceImp implements RegistrationRequestService {

	@Autowired
	RegistrationRequestRepository repository;

	@Override
	public List<RegistrationRequest> getAll() {
		return this.repository.findAll();
	}

	@Override
	public RegistrationRequest get(Long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public RegistrationRequest save(RegistrationRequest registration) {
		return this.repository.save(registration);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}