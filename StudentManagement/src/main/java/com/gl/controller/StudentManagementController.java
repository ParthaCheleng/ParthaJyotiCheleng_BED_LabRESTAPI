package com.gl.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.entity.StudentManagement;
import com.gl.service.StudentManagementService;

@Controller
@RequestMapping("/studentManagement")
public class StudentManagementController {

	private StudentManagementService studentManagementService;
	private Object theStudentManagement;
	
	public StudentManagementController(StudentManagementService thestudentService) {
		studentManagementService = thestudentService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String liststudentMangement(Model theModel) {
		
		
		List<StudentManagement> theStudentManagement = studentManagementService.findAll();
		
		// add to the spring model
		theModel.addAttribute("studentManagement", theStudentManagement);
		
		return "studentManagement/list-students";
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddForm(Model theModel) {
		StudentManagement studentManagement = new StudentManagement();
		
        StudentManagement theStudentManagement = new StudentManagement();
		
		theModel.addAttribute("studentManagement", theStudentManagement);
		
		return "studentManagement/student-form";
	}
	
	
//	@GetMapping("/read")
//	public String readStudent(Model theModel) {
//		
//		
//		List<StudentManagement> theStudentManagement = studentManagementService.findAll();
//		
//		//adding spring model
//		
//		theModel.addAttribute("studentManagement", theStudentManagement);
//		
//		return "studentManagement/read-studentManagement";
//	}
	


	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentManagementId") int theId, Model theModel) {
		
		
		StudentManagement theStudentManagement = studentManagementService.findById(theId);
		
		
		theModel.addAttribute("studentManagement", theStudentManagement);
		
		// send over to our form
		return "studentManagement/studentUpdate-form";			
	}
	
	
	@PostMapping("/save")
	public String saveStudentManagement(@ModelAttribute("studentManagement") StudentManagement theStudentManagement) {
		
		
		studentManagementService.save(theStudentManagement);
		
		return "redirect:/studentManagement/list";
	}
	
	
	@PostMapping("/delete")
	public String delete(@RequestParam("studentManagementId") int theId) {
		
	
		studentManagementService.deleteById(theId);
		
		
		return "redirect:/studentManagement/list";
		
	}
	
}


















