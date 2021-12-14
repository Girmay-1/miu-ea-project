package edu.miu.cs544.courseregistrationsystem.service;

import java.util.List;

import edu.miu.cs544.courseregistrationsystem.model.AcademicBlock;

public interface AcademicBlockService {
	List<AcademicBlock> getAll();
	AcademicBlock save(AcademicBlock t);
	AcademicBlock get(Long id);
    void delete(Long id);

}
