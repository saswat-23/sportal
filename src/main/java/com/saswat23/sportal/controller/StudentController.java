package com.saswat23.sportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.saswat23.sportal.model.Student;

@Controller
@SessionAttributes({"prefixUrl","principalName","user"})
@ControllerAdvice
public class StudentController {
	
	int cnt = 0;
	int dummyCnt = 0;
	
	@ModelAttribute("prefixUrl")
	public String prefixUrl() {
		System.out.println("Inside StudentController - prefixUrl: "+cnt);
		String preUrl = "/temp";
		cnt++;
		return preUrl;
	}
	
	@ModelAttribute("stud")
	public Student dummyStudent() {
		System.out.println("Inside StudentController - dummyStudent: "+dummyCnt);
		Student std = new Student();
		std.setUserid("dummy001");
		std.setUsername("dummy_student_001");
		dummyCnt++;
		return std;
	}
	
	@RequestMapping({"/","/home"})
	public String getHomePage(Model model) {
//		System.out.println("/home: HttpSession - prefiXUrl: "+session.getAttribute("prefixUrl"));
//		System.out.println("/home: modelAttribute - prefiXUrl: "+preUrl);
		System.out.println("/home: model - prefiXUrl: "+model.getAttribute("prefixUrl"));
		System.out.println("/home: model - stud: "+model.getAttribute("stud"));
		String princName = "Dr. Kalam";
		model.addAttribute("principalName",princName);
		return "home";
	}
	
	@RequestMapping("/setUser")
	public String setUser(@ModelAttribute("stud") Student stud, Model model, @SessionAttribute("prefixUrl") String prefixxUrl) {
		System.out.println("/setUser: prefiXUrl from model: "+model.getAttribute("prefixUrl"));
		System.out.println("/setUser: prefiXUrl from sessionAttribute: "+prefixxUrl);
		model.addAttribute("user", stud.getUserid());
		System.out.println("Student Details: "+stud);
		System.out.println("Princi: "+model.getAttribute("principalName"));
		return "dashboard";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model) {
		System.out.println("logout user: "+model.getAttribute("user"));
		return "logout";
	}
	
//	@RequestMapping("/confirmLogout")
//	public String confirmLogout(HttpSession session) {
//		session.removeAttribute("user");
//		return getHomePage(session);
//	}
	
}
