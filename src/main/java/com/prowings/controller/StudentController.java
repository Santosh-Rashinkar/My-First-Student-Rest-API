package com.prowings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Student;
import com.prowings.service.StudentService;

//@Controller
@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/students")
	public String saveStudent(@RequestBody Student student) {

		System.out.println("request  received to save the student to DB!!");
		System.out.println("Incoming student object :" + student);

		boolean res = studentService.saveStudent(student);
		if (res)
			return "student saved successfully!!!";
		else
			return "Error While saving the student!!!";
	}

	@GetMapping("/students")
	public List<Student> getAllStudents() {

		System.out.println("request received to fetch students from DB!!");

		return studentService.getAllStudents();
	}

	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id) {

		System.out.println("request received to fetch students of id:" + id + " from DB!!");

		return studentService.getStudentById(id);
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudentById(@PathVariable int id) {
		
		System.out.println("request received to delete students of id:" + id + " from DB!!");
		
		return studentService.deleteStudentById(id) ? "Deleted successfully" : "Failed to delete";
	}
	
	@GetMapping("/students/search")
	public List<Student> getAllStudentsSearchBy(@RequestParam("city") String address)
	{
		System.out.println("request received to fetch all Students from city : "+address);
		return studentService.findByCity(address);
	}
	
	@GetMapping("/students/sort")
	public List<Student> getAllStudentsSortBy(@RequestParam("field") String field)
	{
		System.out.println("request received to fetch all Students and sort by : "+field);
		return studentService.findAllSortedByField(field);
	}
	@PutMapping("/students")
	public String updateStudent(@RequestBody Student student) {
		
		System.out.println("request  received to update the student");
		System.out.println("Incoming student object :" + student);
		
		boolean res = studentService.updateStudent(student);
		if (res)
			return "student updating successfully!!!";
		else
			return "Error While updating the student!!!";
	}
}
