package com.Bach.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DAOFactory {

	private static final EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("myPUnit");

    private DAOFactory() {
        // Private constructor to prevent instantiation
    }

    public static StudentDAO getStudentDAO() {
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        studentDAO.seteM(entityManagerFactory.createEntityManager());
        return studentDAO;
    }

    // Close the EntityManagerFactory when the application ends
    public static void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
