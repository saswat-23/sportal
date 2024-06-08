package com.saswat23.sportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saswat23.sportal.model.Student;

import jakarta.servlet.http.HttpSession;

@Controller
public class LateralStudentController {
	
	
	@ModelAttribute("prefixUrl")
	public String prefixUrl() {
		System.out.println("Inside LateralStudentController - prefixUrl");
		String preUrl = "/lateral";
		return preUrl;
	}
	
	@RequestMapping({"/lateral"})
	public String getHomePage(HttpSession session) {
		System.out.println("Inside lateral request...");
		return "home";
	}
	
//	@RequestMapping("/setUser")
//	public String setUser(@ModelAttribute("stud") Student stud, HttpSession session) {
//		session.setAttribute("user", stud.getUserid());
//		System.out.println("Student Details: "+stud);
//		
//		return "dashboard";
//	}
//	
//	@RequestMapping("/logout")
//	public String logout(HttpSession session) {
//		return "logout";
//	}
//	
//	@RequestMapping("/confirmLogout")
//	public String confirmLogout(HttpSession session) {
//		session.removeAttribute("user");
//		return getHomePage(session);
//	}
	
}
