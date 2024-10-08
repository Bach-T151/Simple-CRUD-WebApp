package com.Bach.dao;

import java.util.List;

import com.Bach.entity.Student;

public interface StudentDAO {
	    void save(Student student)throws DAOException;
	    Student findById(int id)throws DAOException;
	    List<Student> findAll()throws DAOException;
	    void update(Student student)throws DAOException;
	    void delete(Student student)throws DAOException;
}
