package com.Bach.action;


import java.util.List;

import com.Bach.dao.DAOFactory;
import com.Bach.dao.StudentDAO;
import com.Bach.entity.Student;
import com.Bach.dao.DAOException;

public class StudentAction {

	public List<Student> getStudents(){
		
		StudentDAO studentDAO = DAOFactory.getStudentDAO();
		List<Student> students = null;
		try {
			students = studentDAO.findAll();
		} catch (DAOException e) {
			e.getMessage();
		}
		return students;
	}
	public Student findStudent(int id) {
		StudentDAO studentDAO = DAOFactory.getStudentDAO();
		Student student= null;
		try {
			student= studentDAO.findById(id);
			
		} catch (DAOException e) {
			e.getMessage();
		}
		return student;
		
	}
	
	public void deleteStudent(Student student) {
		StudentDAO studentDAO = DAOFactory.getStudentDAO();
		try {
			studentDAO.delete(student);
			
		} catch (DAOException e) {
			e.getMessage();
		}
	}
	public void saveStudent(Student student) {
		StudentDAO studentDAO = DAOFactory.getStudentDAO();
		try {
			studentDAO.save(student);
			
		} catch (DAOException e) {
			e.getMessage();
		}
	}
	public void upDateStudent(Student student) {
		StudentDAO studentDAO = DAOFactory.getStudentDAO();
		try {
			studentDAO.update(student);
			
		} catch (DAOException e) {
			e.getMessage();
		}
	}
}
