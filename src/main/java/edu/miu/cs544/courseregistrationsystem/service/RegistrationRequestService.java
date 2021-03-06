package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import edu.miu.cs544.courseregistrationsystem.model.RegistrationRequest;

public interface RegistrationRequestService {
	List<RegistrationRequest> getAll();

	RegistrationRequest save(RegistrationRequest t);

	RegistrationRequest get(Long id);

	void delete(Long id);
}
