package com.saswat23.sportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saswat23.sportal.model.Student;
import com.saswat23.sportal.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@RequestMapping({"/","/home"})
	public String getHomePage(HttpSession session) {
		session.removeAttribute("deletionState");
		return "home";
	}
	
	@RequestMapping("/setUser")
	public String setUser(@ModelAttribute("stud") Student stud, HttpSession session) {
		session.setAttribute("user", stud.getUserid());
		List<Student> students = service.getAllStudents();
		session.setAttribute("studList", students);
		if(!students.isEmpty()) {
			session.setAttribute("deletionState","Student data is present!");
		}
		return "dashboard";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		return "logout";
	}
	
	@RequestMapping("/confirmLogout")
	public String confirmLogout(HttpSession session) {
		session.removeAttribute("user");
		return getHomePage(session);
	}
	
	@RequestMapping("/deleteAllStudents")
	public String deleteAllStudents(HttpSession session) {
		if(service.deleteAllStudents()) {
			session.setAttribute("deletionState", "<span style=\"background:green;\">All Student data deleted sucessfully!</span>");
		}
		else {
			session.setAttribute("deletionState", "<span style=\"background:red;\">All Student data couldn't be deleted</span>");
		}
		session.setAttribute("studList", service.getAllStudents());
		return "dashboard";
	}
	
}
