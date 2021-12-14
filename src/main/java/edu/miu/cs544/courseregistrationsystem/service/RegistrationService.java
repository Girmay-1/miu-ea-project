package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import edu.miu.cs544.courseregistrationsystem.model.Registration;

public interface RegistrationService {
	List<Registration> getAll();

	Registration save(Registration t);

	Registration get(Long id);

	void delete(Long id);
}
