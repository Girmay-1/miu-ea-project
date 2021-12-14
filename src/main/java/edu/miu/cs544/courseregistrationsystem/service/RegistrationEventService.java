package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import edu.miu.cs544.courseregistrationsystem.model.RegistrationEvent;

public interface RegistrationEventService {
	List<RegistrationEvent> getAll();

	RegistrationEvent save(RegistrationEvent t);

	RegistrationEvent get(Long id);

	void delete(Long id);
}
