package com.jensen.spring.dao;

import java.util.List;

import com.jensen.spring.entity.Teacher;

/**
 * TeacherDAO interface with  methods
 * 
 * @author Shul, Oskwik
 * @version 2.0
 */
public interface TeacherDAO {
	
	public List<Teacher> getTeachers();

	public void saveTeacher(Teacher theTeacher);

	public Teacher getTeacher(int theId);

	public void deleteTeacher(int theId);

	public List<Teacher> searchTeachers(String theSearchName);

}
