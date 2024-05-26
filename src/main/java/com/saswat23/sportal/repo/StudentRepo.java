package com.saswat23.sportal.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.saswat23.sportal.model.Student;

@Repository
public class StudentRepo {

	List<Student> students;
	
	{
		students = new ArrayList<Student>();
		students.add(new Student("S101","Saswat",12,67.5d));
		students.add(new Student("S102","Sarita",15,96.3d));
		students.add(new Student("S103","Dadu",29,81.7d));
	}
	
	public List<Student> findAll() {
		return students;
	}

	public List<Student> deleteAll() {
		if(!students.isEmpty()) {
			students.clear();
		}
		return students;
	}

}
