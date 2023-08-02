package com.gl.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dao.StudentManagementRepository;
import com.gl.entity.StudentManagement;

@Service
public class StudentManagementServiceImpl implements StudentManagementService {

	
	private StudentManagementRepository studentManagementRepository;

	@Autowired
	public StudentManagementServiceImpl(StudentManagementRepository thestudentManagementRepository) {
		studentManagementRepository = thestudentManagementRepository;
	}

	@Override
	public List<StudentManagement> findAll() {

		List<StudentManagement> theStudentManagement = studentManagementRepository.findAll();
		return theStudentManagement;
	}

	@Override
	public StudentManagement findById(int theId) {
		Optional<StudentManagement> result = studentManagementRepository.findById(theId);

		StudentManagement thestudentManagement = null;

		if (result.isPresent()) {
			thestudentManagement = result.get();
		} else {
			
			throw new RuntimeException("Did not find student id - " + theId);
		}

		return thestudentManagement;
	}

	@Override
	public void save(StudentManagement thestudentManagement) {
		studentManagementRepository.save(thestudentManagement);
	}

	@Override
	public void deleteById(int theId) {
		studentManagementRepository.deleteById(theId);
	}

}
