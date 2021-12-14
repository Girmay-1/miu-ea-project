package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs544.courseregistrationsystem.model.AcademicBlock;
import edu.miu.cs544.courseregistrationsystem.repository.AcademicBlockRepository;

@Service
public class AcademicBlockServiceImp implements AcademicBlockService {

	@Autowired
	AcademicBlockRepository repository;

	@Override
	public List<AcademicBlock> getAll() {
		return this.repository.findAll();
	}

	@Override
	public AcademicBlock get(Long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public AcademicBlock save(AcademicBlock academicBlock) {
		return this.repository.save(academicBlock);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}