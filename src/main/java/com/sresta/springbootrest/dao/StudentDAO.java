package com.sresta.springbootrest.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sresta.springbootrest.entity.Student;

@Repository
public class StudentDAO {

	public List<Student> students = new ArrayList<Student>();

	public StudentDAO() {
		genDefaultStudent();
	}

	private void genDefaultStudent() {

		Student std1 = new Student("K00420275", "Rujen Raj Shrestha", 27);
		Student std2 = new Student("K00420270", "Tom Hanks", 47);
		Student std3 = new Student("K00420200", "Birdie Jones", 37);

		students.add(std1);
		students.add(std2);
		students.add(std3);

	}

	public List<Student> getAllStudent() {
		return this.students;
	}

	public Student getStudentById(String uId) {
		Iterator<Student> i = students.iterator();
		while (i.hasNext()) {
			Student std = i.next();
			if (std.getuID().equals(uId)) {
				return std;
			}
		}
		return null;
	}

	public String saveStudent(Student std) {
		String result = "-1";
		students.add(std);
		result = "Student Record Saved Succesfully";
		return result;
	}

	public String deleteStudent(String uId) {
		String result = "-1";
		Iterator<Student> i = students.iterator();
		while (i.hasNext()) {
			Student std = i.next();
			if (std.getuID().equals(uId)) {
				i.remove();
				result = "Student Record Deleted Succesfully";
			}
		}
		return result;
	}

}
