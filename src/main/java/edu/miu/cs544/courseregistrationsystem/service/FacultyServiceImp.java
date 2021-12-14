package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.Faculty;
import edu.miu.cs544.courseregistrationsystem.repository.FacultyRepository;

@Service
public class FacultyServiceImp implements FacultyService{

	@Autowired
	FacultyRepository repository;

	@Override
	public List<Faculty> getAll() {
		return this.repository.findAll();
	}

	@Override
	public Faculty get(Long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public Faculty save(Faculty faculty) {
		return this.repository.save(faculty);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}