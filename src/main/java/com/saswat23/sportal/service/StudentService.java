package com.saswat23.sportal.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saswat23.sportal.model.Student;
import com.saswat23.sportal.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;
	
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	public boolean deleteAllStudents() {
		if(repo.deleteAll().isEmpty()) {
			if( (new Random()).nextInt(10)%2 ==0 ) {
				return false;
			}
			return true;
		}
		return false;
	}

	public String deleteStudent(Student stud) {
		return repo.delete(stud)?"Student ["+stud.getUserid()+"] deleted successfully!"
								:"Student ["+stud.getUserid()+"] couldn't be deleted!";
	}

	public Student updateStudent(Student stud) {
		if(stud.getUserid()==null) {
			return new Student("-1","-1",-1,-1d);
		}
		return repo.update(stud);
	}

	public List<Student> addStudent(Student stud) {
		return repo.add(stud);
	}
	
	public List<Student> restoreStudentData() {
		return repo.restoreStudents();
	}

	public Student getStudent(String studentId) {
		return repo.getStudent(studentId);
	}
	
}
