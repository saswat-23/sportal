package com.saswat23.sportal.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saswat23.sportal.model.Student;
import com.saswat23.sportal.service.StudentService;

@RestController
public class StudentRestController {
	
	@Autowired
	private StudentService service;
	
	@RequestMapping(path = {"/", "/students"}, method = RequestMethod.GET)
	public List<Student> getAllStudents() {
		List<Student> studs = service.getAllStudents();
		return studs;
	}
	
	@RequestMapping(path = "/student", method = RequestMethod.POST)
	public void addStudent(@RequestBody Student stud) {
		service.addStudent(stud);
	}
	
	
	@RequestMapping(path = "/student/{studentId}", method =  RequestMethod.GET)
	public Student getStudent(@PathVariable("studentId") String studentId) {
		return service.getStudent(studentId);
	}
	
	
	@RequestMapping(path = "/student", method = RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}
	
	@RequestMapping(path = "/student/{studentId}", method =  RequestMethod.DELETE)
	public String deleteStudent(@PathVariable("studentId") String studentId) {
		Student stud = new Student();
		stud.setUserid(studentId);
		return service.deleteStudent(stud);
	}
	
	@RequestMapping(path = "/deleteAll", method = RequestMethod.DELETE)
	public String deleteAllStudents() {
		if(service.deleteAllStudents()) {
			return "All student details deleted successfully!";
		}
		return "Student data not deleted!"+getAllStudents().toString();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/restoreData")
	public List<Student> restoreAllStudents() {
		return service.restoreStudentData();
	}
	
}
