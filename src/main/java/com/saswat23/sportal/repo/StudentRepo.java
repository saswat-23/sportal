package com.saswat23.sportal.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SimplePropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saswat23.sportal.model.Student;

@Repository
public class StudentRepo {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	RowMapper<Student> studentRowMapper = new SimplePropertyRowMapper<>(Student.class);
	
	private List<Student> students;
	
//	private BiPredicate<String, String> studIdMatchPredicate = (sid1, sid2) -> sid1.equals(sid2);
	
	public List<Student> findAll() {
		String sql = "select * from student;";
		students = jdbcTemplate.query(sql, studentRowMapper);
		return students;
	}

	public List<Student> deleteAll() {
		String sql = "delete from student;";
		if(jdbcTemplate.update(sql)>0)
			System.out.println("Records deleted from student table.");
		return findAll();
	}

	public boolean delete(Student stud) {
		String sql = "delete from student where userid=?";
		int res = jdbcTemplate.update(sql, stud.getUserid());
		return res>0?true:false;
	}

	public Student update(Student stud) {
		if(getStudent(stud.getUserid())==null) {
			return null;
		}
		String sql = "update student from student where userid=?";
		int res = jdbcTemplate.update(sql, stud.getUserid());
		return res>0?getStudent(stud.getUserid()):null;
	}

	public List<Student> add(Student stud) {
		String sql = "insert into student (userid, username, rollno, marks) values (?,?,?,?)";
		jdbcTemplate.update(sql, stud.getUserid(), stud.getUsername(), stud.getRollNo(), stud.getMarks());
		return findAll();
	}

	public List<Student> restoreStudents() {
		restoreData();
		return findAll();
	}
	
	@Transactional
	private void restoreData() {
		students = new ArrayList<Student>();
		students.add(new Student("S111","Saswat",12,67.5d));
		students.add(new Student("S112","Sarita",15,96.3d));
		students.add(new Student("S113","Dadu",29,81.7d));
		students.add(new Student("S114","Lovely",35,99.01d));
		
		String sql = "insert into student (userid, username, rollno, marks) values (?,?,?,?);";
		
		try {
			students.forEach(s-> jdbcTemplate.update(sql, s.getUserid(), s.getUsername(), s.getRollNo(), s.getMarks()));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public Student getStudent(String studentId) {
		String sql = "select * from student where userid = ?";
		Student stud = jdbcTemplate.queryForObject(sql, studentRowMapper, studentId);
		return stud;
	}
	
}
