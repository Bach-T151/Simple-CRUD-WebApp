package com.Bach.dao;


import java.util.List;

import com.Bach.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;


public class StudentDAOImpl implements StudentDAO{
	@PersistenceContext
	private EntityManager eM;

	public void seteM(EntityManager eM) {
		this.eM = eM;
	}

	public EntityManager geteM() {
		return eM;
	}

	@Override
	public void save(Student student) throws DAOException {
		EntityTransaction eT= eM.getTransaction();
		try {
			eT.begin();
			eM.persist(student);
			eT.commit();
		} catch (Exception e) {
			if (eT.isActive()) {
                eT.rollback(); // Rollback in case of an error
            }
            throw new DAOException("Error saving student",e);
		}finally {
            
                eM.close();  // Close the EntityManager here after work is done
        }
		
	}

	@Override
	public Student findById(int id) throws DAOException {
		try {
            return eM.find(Student.class, id);
        } catch (Exception e) {
            throw new DAOException("Error finding student by id",e);
        }finally {
            
            eM.close();  // Close the EntityManager here after work is done
         }
	}

	@Override
	public List<Student> findAll() throws DAOException {
		
		 try {
			
	            return eM.createQuery("FROM Student", Student.class).getResultList();
	        } catch (Exception e) {
	            throw new DAOException("Error finding all students",e);
	        }finally {
	            
	                eM.close();  // Close the EntityManager here after work is done
	            
	        }
	}

	@Override
	public void update(Student student) throws DAOException {
		 EntityTransaction eTransaction = eM.getTransaction();
	        try {
	            eTransaction.begin();
	            eM.merge(student);
                eTransaction.commit();
	        } catch (Exception e) {
	            if (eTransaction.isActive()) {
	                eTransaction.rollback();
	            }
	            throw new DAOException("Error updating student",e);
	        }finally {
	            
	                eM.close();  // Close the EntityManager here after work is done
	           
	        }
		
	}

	@Override
	public void delete(Student student) throws DAOException {
		 EntityTransaction eTransaction = eM.getTransaction();
	        try {
	            eTransaction.begin();
	            // If the entity is not managed, merge it first before removing
	            eM.remove(eM.contains(student) ? student : eM.merge(student));
	            eTransaction.commit();
	        } catch (Exception e) {
	            if (eTransaction.isActive()) {
	                eTransaction.rollback();
	            }
	            throw new DAOException("Error deleting student",e);
	        }finally {
	           
	             eM.close();  // Close the EntityManager here after work is done
	            
	        }
		
	}


}
