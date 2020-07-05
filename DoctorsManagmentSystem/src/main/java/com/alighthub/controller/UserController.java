package com.alighthub.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alighthub.dms.model.Feedback;
import com.alighthub.dms.model.Login;
import com.alighthub.dms.model.Student;
import com.alighthub.dms.service.ServiceDMS;

/*
 * 
 * @author Ravindra Sonawane
 * @page User Controller
 * @time 08/09/2019 - 9.05 PM
 * @purpose User Controller
 * 
 *
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	
	
    @Autowired
    private ServiceDMS service;
	 @RequestMapping(value = "/get/{username}/{password}")
	 public Login getLoginUnameAndPassword(@PathVariable String username,@PathVariable String password)
	 {
		 return service.getLoginUnameAndPassword(username, password);
	 }
	 @PostMapping(value = "/addfeed")
	 public String addFeedback(@RequestBody Feedback feedback)
	 {
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			System.out.println(formatter.format(date));
			String d=formatter.format(date);
			feedback.setFeedbackDate(d);
			service.addFeed(feedback);
		 return "add Feedback Successfully";
	 }
	 @GetMapping(value = "/getFeed")
	 public List<Feedback> getFeedback()
	 {
		List<Feedback> st= service.getFeed();
		
		 return st;
	 }
	 
	 @GetMapping(value ="getstd")
	 public List<Student> get()
	 {  
		 List<Student> st=service.get();
		 
		 for(Student s:st)
		 {
			 System.out.println(s.getStudentEmail());
		     List<Feedback>	 fdk =s.getFedd();
		
		    for(Feedback f:fdk)
		{
			
			System.out.println("nnnsjn");
			System.out.println(f.getFeedText());
		}
		
		}
		 return st;
		 
	 }
	 @PostMapping(value = "addstud")
	 public String addStud(@RequestBody Student std)
	 {   
		 service.addStudent(std);
		 return "add Student";
	 }
}
