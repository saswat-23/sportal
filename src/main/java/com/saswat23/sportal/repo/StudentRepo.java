package com.saswat23.sportal.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import org.springframework.stereotype.Repository;

import com.saswat23.sportal.model.Student;

@Repository
public class StudentRepo {

	private List<Student> students;
	
	private BiPredicate<String, String> studIdMatchPredicate = (sid1, sid2) -> sid1.equals(sid2);
	
	
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

	public boolean delete(Student stud) {
		boolean removeStat = false;
		for (Student student : students) {
			if(student.getUserid().equals(stud.getUserid())) {
				removeStat = students.remove(student);
				break;
			}
		}
		return removeStat;
	}

	public Student update(Student stud) {
		boolean updtStat=false;
		for (Student student : students) {
			if(studIdMatchPredicate.test(stud.getUserid(), student.getUserid())) {
				student.copyValues(stud);
				updtStat = true;
				break;
			}
		}
		return updtStat?stud:null;
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

	public Student getStudent(String studentId) {

		for (Student student : students) {
			if(studIdMatchPredicate.test(studentId, student.getUserid())) {
				return student;
			}
		}
		return null;
	}

}
