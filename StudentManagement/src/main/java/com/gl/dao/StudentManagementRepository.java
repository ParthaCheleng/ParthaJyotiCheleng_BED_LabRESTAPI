package com.gl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.entity.StudentManagement;

public interface StudentManagementRepository extends JpaRepository<StudentManagement, Integer> {

}
