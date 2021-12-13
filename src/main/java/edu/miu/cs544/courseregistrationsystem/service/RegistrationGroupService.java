package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.RegistrationGroup;
import edu.miu.cs544.courseregistrationsystem.repository.RegistrationGroupRepository;

@Service
public class RegistrationGroupService {

	@Autowired
	RegistrationGroupRepository repository;

	public List<RegistrationGroup> getAllCourses() {
		return this.repository.findAll();
	}

	public RegistrationGroup readCourse(Long id) {
		return this.repository.findById(id).get();
	}

	public RegistrationGroup save(RegistrationGroup registrationGroup) {
		return this.repository.save(registrationGroup);
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}