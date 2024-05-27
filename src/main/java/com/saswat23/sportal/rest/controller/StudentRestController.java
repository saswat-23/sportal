package com.saswat23.sportal.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saswat23.sportal.model.Student;
import com.saswat23.sportal.service.StudentService;

@Controller
public class StudentRestController {
	
	@Autowired
	private StudentService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/")
	@ResponseBody
	public List<Student> getAllStudents() {
		List<Student> studs = service.getAllStudents();
		return studs;
	}
	
	@RequestMapping("/deleteStudent")
	public void deleteStudent(Student stud) {
		service.deleteStudent(stud);
	}
	
	@RequestMapping(path = "/deleteAll", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteAllStudents() {
		if(service.deleteAllStudents()) {
			return "All student details deleted successfully!";
		}
		return "Student data not deleted!"+getAllStudents().toString();
	}
	
	@RequestMapping("/updateStudent")
	public void updateStudent(Student stud) {
		service.updateStudent(stud);
	}
	
	@RequestMapping("/addStudent")
	public void addStudent(Student stud) {
		service.addStudent(stud);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/restoreData")
	@ResponseBody
	public List<Student> restoreAllStudents() {
		return service.restoreStudentData();
	}
}
