package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import edu.miu.cs544.courseregistrationsystem.model.Faculty;

public interface FacultyService {
	List<Faculty> getAll();
	Faculty save(Faculty t);
	Faculty get(Long id);
    void delete(Long id);
}
