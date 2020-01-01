package com.sresta.springbootrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.sresta.springbootrest.dao.StudentDAO;
import com.sresta.springbootrest.entity.Student;

@RestController
public class StudentController {
	
	@Autowired
	StudentDAO dao;

	/*
	 * @RequestMapping("students") public List<Student> getStudents(){ List<Student>
	 * students = new ArrayList<Student>();
	 * 
	 * Student std1 = new Student(); std1.setuID("K00420275");
	 * std1.setName("Rujen Shrestha"); std1.setAge(26);
	 * 
	 * Student std2 = new Student(); std1.setuID("K00420280");
	 * std1.setName("Rujen Shrestha"); std1.setAge(28);
	 * 
	 * students.add(std1); students.add(std2);
	 * 
	 * return students; }
	 */
	
	@GetMapping(path="/students")
	public List<Student> getAllStudent(){
		System.out.println("RESTCONTROLLER WORKING");
		List<Student> students = dao.getAllStudent();
		return students;
	}
	
	@GetMapping(path="/students/student/{uId}")
	public Student getStudentById(@PathVariable String uId) {
		Student student = dao.getStudentById(uId);
		
		/*
		 * ControllerLinkBuilder linkTo =
		 * ControllerLinkBuilder.linkTo(methodOn(this.getClass()).getAllStudent());
		 * EntityModel<Student> resource = new
		 * EntityModel<Student>(dao.getStudentById(uId));
		 * resource.add(linkTo.withRel("all-student"));
		 */
		return student;
	}
	
	@PostMapping(path="/students/student")
	public String saveStudent(@RequestBody Student std) {
		String result = dao.saveStudent(std);
		return result;
	}
	
	@DeleteMapping(path="/students/student/{id}")
	public String deleteStudent(@PathVariable("id") String uId) {
		String result = dao.deleteStudent(uId);
		return result;
	}
}
