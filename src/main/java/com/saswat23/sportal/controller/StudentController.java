package com.saswat23.sportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saswat23.sportal.model.Student;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	
	int cnt = 0;
	
	@ModelAttribute("prefixUrl")
	public String prefixUrl() {
		System.out.println("Inside StudentController - prefixUrl: "+cnt);
		String preUrl = "";
		cnt++;
		return preUrl;
	}
	
	@RequestMapping({"/","/home"})
	public String getHomePage(HttpSession session) {
		System.out.println("/home: prefiXUrl from model: "+session.getAttribute("prefixUrl"));
		return "home";
	}
	
	@RequestMapping("/setUser")
	public String setUser(@ModelAttribute("stud") Student stud, HttpSession session) {
		System.out.println("/setUser: prefiXUrl from model: "+session.getAttribute("prefixUrl"));
		session.setAttribute("user", stud.getUserid());
		System.out.println("Student Details: "+stud);
		
		return "dashboard";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("/logout: prefiXUrl from model: "+session.getAttribute("prefixUrl"));
		return "logout";
	}
	
	@RequestMapping("/confirmLogout")
	public String confirmLogout(HttpSession session) {
		session.removeAttribute("user");
		return getHomePage(session);
	}
	
}
