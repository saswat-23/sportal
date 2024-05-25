package com.saswat23.sportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.saswat23.sportal.model.Student;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	
	@RequestMapping({"/","/home"})
	public String getHomePage(HttpSession session) {
		return "home";
	}
	
	@RequestMapping("/setUser")
	public String setUser(@ModelAttribute("stud") Student stud, HttpSession session) {
		session.setAttribute("user", stud.getUserid());
		
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
	
}
