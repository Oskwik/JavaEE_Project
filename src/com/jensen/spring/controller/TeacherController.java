package com.jensen.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jensen.spring.dao.TeacherDAO;
import com.jensen.spring.entity.Teacher;
import com.jensen.spring.service.TeacherService;

/**
 *  TeacherControllerServlet with  search/
 *  update/delete/add/save- Teachers  methods
 * 
 * @author Shul, Oskwik
 * @version 2.0
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	// to inject teacher service
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/list")
	public String listTeachers(Model theModel) {
		
		// get teachers from service
		List<Teacher> theTeachers = teacherService.getTeachers();
		
		// add the teachers to Spring-MVC model
		theModel.addAttribute("teachers",theTeachers);
		
		return "list-teachers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String addForm(Model theModel) {
		
		// create model attribute to bind form data
		Teacher theTeacher = new Teacher();
		
		theModel.addAttribute("teacher", theTeacher);
		
		return "teacher-form";
	}
	
	@PostMapping("/saveTeacher")
	public String saveTeacher(@ModelAttribute("teacher") Teacher theTeacher) {
		
		// save the teacher using service
		teacherService.saveTeacher(theTeacher);
				
		return "redirect:/teacher/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateForm(@RequestParam("teacherId") int theId, Model theModel) {
		
		// get the teacher from service
		Teacher theTeacher = teacherService.getTeacher(theId); 
		
		// model attribute to pre-populate the form
		theModel.addAttribute("teacher", theTeacher);
		
		// send over to form
		
		return "teacher-form";
	}
	
	@GetMapping("/delete")
	public String deleteForm(@RequestParam("teacherId") int theId) {
		
		// delete the teacher
		teacherService.deleteTeacher(theId);
		
		return "redirect:/teacher/list";
	}
	
	@PostMapping("/search")
    public String searchTeachers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search  from the service
        List<Teacher> theTeachers = teacherService.searchTeachers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("teachers", theTeachers);

        return "list-teachers";        
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
