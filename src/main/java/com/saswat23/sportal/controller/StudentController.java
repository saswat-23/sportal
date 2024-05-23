package com.saswat23.sportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	
	@RequestMapping({"/","/home"})
	public String getHomePage() {
		System.out.println("HomePage...");
		return "home";
	}
	
	@RequestMapping("/setUser")
	public String setUser(@RequestParam(required = true, name = "userid") String userid, HttpSession session) {
		System.out.println("SetUser called. "+userid);
		session.setAttribute("userId", userid);
		return "dashboard";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("Logout called.. "+session.getAttribute("userId"));
		return "logout";
	}
	
}
