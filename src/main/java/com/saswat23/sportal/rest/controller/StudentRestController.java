package com.saswat23.sportal.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saswat23.sportal.model.Student;
import com.saswat23.sportal.service.StudentService;

@RestController
public class StudentRestController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping(path={"/", "/students"}, produces = {"application/json"})
	public List<Student> getAllStudents() {
		List<Student> studs = service.getAllStudents();
		return studs;
	}
	
	@PostMapping(path = "/student", consumes = "application/xml")
	public void addStudent(@RequestBody Student stud) {
		service.addStudent(stud);
	}
	
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable("studentId") String studentId) {
		return service.getStudent(studentId);
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}
	
	@DeleteMapping("/student/{studentId}")
	public String deleteStudent(@PathVariable("studentId") String studentId) {
		Student stud = new Student();
		stud.setUserid(studentId);
		return service.deleteStudent(stud);
	}
	
	@DeleteMapping("/students")
	public String deleteAllStudents() {
		if(service.deleteAllStudents()) {
			return "All student details deleted successfully!";
		}
		return "Student data not deleted!"+getAllStudents().toString();
	}
	
	@GetMapping("/restoreData")
	public List<Student> restoreAllStudents() {
		return service.restoreStudentData();
	}
	
}
