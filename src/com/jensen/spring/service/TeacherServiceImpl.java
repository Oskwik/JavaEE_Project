package com.jensen.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jensen.spring.dao.TeacherDAO;
import com.jensen.spring.entity.Teacher;

/**
 * The implementation of TeacherService interface with methods to work with various DAO objects
 * 
 * @author Shul, Oskwik
 * @version 2.0
 */
@Service
public class TeacherServiceImpl implements TeacherService {

	// to inject teacher DAO
	@Autowired
	private TeacherDAO teacherDAO;
	
	@Override
	@Transactional
	public List<Teacher> getTeachers() {
		return teacherDAO.getTeachers();
	}

	@Override
	@Transactional
	public void saveTeacher(Teacher theTeacher) {
		
		teacherDAO.saveTeacher(theTeacher);
		
	}

	@Override
	@Transactional
	public Teacher getTeacher(int theId) {
		
		return teacherDAO.getTeacher(theId);
	}

	@Override
	@Transactional
	public void deleteTeacher(int theId) {
		
		teacherDAO.deleteTeacher(theId);
	}

	@Override
	@Transactional
	public List<Teacher> searchTeachers(String theSearchName) {
		
		return teacherDAO.searchTeachers(theSearchName);
	}

}
