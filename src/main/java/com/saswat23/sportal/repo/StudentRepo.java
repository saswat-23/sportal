package com.saswat23.sportal.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.saswat23.sportal.model.Student;

@Repository
public class StudentRepo {

	private List<Student> students;
	
	{
		restoreData();
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

	public Student delete(Student stud) {
		for (Student student : students) {
			if(student.getUserid().equals(stud.getUserid())) {
				//delete
			}
		}
		return stud;
	}

	public Student update(Student stud) {
		for (Student student : students) {
			if(student.getUserid().equals(stud.getUserid())) {
				//update
			}
		}
		return stud;
	}

	public List<Student> add(Student stud) {
		students.add(stud);
		return students;
	}

	public List<Student> restoreStudents() {
		restoreData();
		return students;
	}
	
	private void restoreData() {
		students = new ArrayList<Student>();
		students.add(new Student("S101","Saswat",12,67.5d));
		students.add(new Student("S102","Sarita",15,96.3d));
		students.add(new Student("S103","Dadu",29,81.7d));
		students.add(new Student("S104","Lovely",35,99.01d));
	}

}
