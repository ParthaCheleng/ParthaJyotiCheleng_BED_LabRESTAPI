package com.gl.service;

import java.util.List;

import org.springframework.ui.Model;

import com.gl.entity.StudentManagement;

public interface StudentManagementService {

	public List<StudentManagement> findAll();
	
	public StudentManagement findById(int theId);
	
	public void save(StudentManagement theStudentManagement);
	
	public void deleteById(int theId);

		
}
