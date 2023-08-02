package com.gl.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentManagement {

	// define fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int student_id;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "course")
	private String course;
	
	@Column(name = "country")
	private String country;

	public StudentManagement() {

	}

	public StudentManagement(int student_id, String first_name, String last_name, String course, String country) {
		this.student_id = student_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.course = course;
		this.country = country;
	}

	public StudentManagement(String first_name, String last_name, String course, String country) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.course = course;
		this.country = country;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
    
	
	

	
}
