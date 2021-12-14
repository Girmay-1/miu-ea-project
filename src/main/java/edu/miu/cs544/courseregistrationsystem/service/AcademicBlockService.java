package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.AcademicBlock;
import edu.miu.cs544.courseregistrationsystem.repository.AcademicBlockRepository;

@Service
public class AcademicBlockService implements IAcademicBlockService {

	@Autowired
	AcademicBlockRepository repository;

	public List<AcademicBlock> getAllCourses() {
		return this.repository.findAll();
	}

	public AcademicBlock readCourse(Long id) {
		return this.repository.findById(id).get();
	}

	public AcademicBlock save(AcademicBlock academicBlock) {
		return this.repository.save(academicBlock);
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}