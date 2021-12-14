package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;
import edu.miu.cs544.courseregistrationsystem.model.RegistrationGroup;

public interface RegistrationGroupService {
	List<RegistrationGroup> getAll();

	RegistrationGroup save(RegistrationGroup t);

	RegistrationGroup get(Long id);

	void delete(Long id);
}
