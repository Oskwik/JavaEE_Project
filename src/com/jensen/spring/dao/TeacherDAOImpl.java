package com.jensen.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jensen.spring.entity.Teacher;

/**
 * The implementation of TeacherDAO interface with methods
 * 
 * @author Shul, Oskwik
 * @version 2.0
 */
@Repository
public class TeacherDAOImpl implements TeacherDAO {
	
	// to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Teacher> getTeachers() {
		
		// the current hibernate session
		Session curSession = sessionFactory.getCurrentSession();
		
		// create Hibernate query sort by Teacher Number
		Query<Teacher> theQuery =
				curSession.createQuery("from Teacher order by nr", Teacher.class);
		
		// execute query and get result list
		List<Teacher> teachers = theQuery.getResultList();
		
		return teachers;
	}

	@Override
	public void saveTeacher(Teacher theTeacher) {
		
		// get current hibernate session
		Session curSession = sessionFactory.getCurrentSession();
		
		// save/update the teacher
		curSession.saveOrUpdate(theTeacher);
		
	}

	@Override
	public Teacher getTeacher(int theId) {
		
		// get current hibernate session
		Session curSession = sessionFactory.getCurrentSession();
				
		// read from DB using the primary key
		Teacher theTeacher = curSession.get(Teacher.class, theId);
		
		return theTeacher;
	}

	@Override
	public void deleteTeacher(int theId) {
		
		// get current hibernate session
		Session curSession = sessionFactory.getCurrentSession();
		
		// delete from DB using the primary key: Ver.1
		///Teacher theTeacher = curSession.get(Teacher.class, theId);
		///curSession.delete(theTeacher);
		
		// delete from DB: Ver.2
		Query theQuery = 
				curSession.createQuery("delete from Teacher where id=:tId");
		theQuery.setParameter("tId", theId);
				
		theQuery.executeUpdate();	
	}

	@Override
	public List<Teacher> searchTeachers(String theSearchName) {
		
		Session curSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =curSession.createQuery("from Teacher where lower(firstName) like :theStr or lower(lastName) like :theStr", Teacher.class);
            theQuery.setParameter("theStr", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            theQuery =curSession.createQuery("from Teacher", Teacher.class);            
        }
        
       List<Teacher> teachers = theQuery.getResultList();
                
       return teachers;
	}

}
