package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.*;
import edu.miu.cs544.courseregistrationsystem.repository.RegistrationGroupRepository;

@Service
public class RegistrationGroupServiceImp implements RegistrationGroupService {

	@Autowired
	RegistrationGroupRepository repository;

	@Override
	public List<RegistrationGroup> getAll() {
		return this.repository.findAll();
	}

	@Override
	public RegistrationGroup get(Long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public RegistrationGroup save(RegistrationGroup registrationGroup) {
		return this.repository.save(registrationGroup);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

	@Override
    public List<RegistrationGroup> findByRegistrationEvent(Long registrationEvent) {
        return repository.findByRegistrationId(registrationEvent);
    }
}