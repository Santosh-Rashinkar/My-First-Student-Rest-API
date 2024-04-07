package com.prowings.service;

import java.util.List;

import com.prowings.entity.Student;

public interface StudentService {

	public boolean saveStudent(Student student);

	public Student getStudentById(int id);
	
	public List<Student> getAllStudents();

	public List<Student> findByCity(String address);

	public List<Student> findAllSortedByField(String field);

	public boolean deleteStudentById(int id);

	public boolean updateStudent(Student student);
}
