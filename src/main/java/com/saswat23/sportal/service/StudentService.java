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

	public Student deleteStudent(Student stud) {
		return repo.delete(stud);
	}

	public Student updateStudent(Student stud) {
		return repo.update(stud);
	}

	public List<Student> addStudent(Student stud) {
		return repo.add(stud);
	}
	
	public List<Student> restoreStudentData() {
		return repo.restoreStudents();
	}
	
}
