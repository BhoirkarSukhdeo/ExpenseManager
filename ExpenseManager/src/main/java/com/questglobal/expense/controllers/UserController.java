package com.questglobal.expense.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questglobal.expense.model.Expense;
import com.questglobal.expense.model.User;
import com.questglobal.expense.serviceinterface.UserService;
@RestController
@RequestMapping(value = "/userController")
public class UserController {

	@Autowired
	private UserService userService;
	
	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(value = "/openIndex")
	public String openIndex()
	{
		logger.info("UserController :: openIndex method");
	    return "login";
	}
	
	@GetMapping(value = "/openRegister")
	public String openRegisterPage(Model model)
	{
		logger.debug("UserController :: openRegisterPage method");
		model.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping(value = "/addUser")
	public String addUserDetails(@Valid User user,BindingResult br)
	{
		logger.info("UserController :: addUserDetails Method called");
		if(br.hasErrors())
		{
		   logger.error("UserController :: error occured at register page");  
		   return "register";
		}
		else
		{
		    userService.addUserDetails(user);
		    logger.info("User Details add Successfully");
		    return "login";
		}
    	
	}
	
	@GetMapping(value = "/loginform/userEmail/{userEmail}/userPassword/{userPassword}")
	public ResponseEntity<List<Expense>> displaySuccessPage(@PathVariable String userEmail,@PathVariable  String userPassword)throws EntityNotFoundException
	{
		
		List<Expense> expenseList=null;
		logger.info("UserController :: displaySuccessPage method called with "+userEmail,userPassword);
		User user=userService.findByUserEmailAndUserPassword(userEmail, userPassword);
		
		if(user.getUserEmail().equals(userEmail)&& user.getUserPassword().equals(userPassword))
		  {
			 expenseList= userService.displayExpense(user.getUserId());
		  }
			 return new ResponseEntity<List<Expense>>(expenseList,HttpStatus.OK);
         
	 }
	
		
	@GetMapping("/pagination/{userId}/{pageNo}/{pageSize}")
    public ResponseEntity<List<Expense>> getAllExpense(@PathVariable Integer userId,
                        @PathVariable Integer pageNo,@PathVariable Integer pageSize)
                        
    {
		logger.info("UserController :: getAllExpense Method Call..paginatio");
        List<Expense> list = userService.getAllExpense(userId,pageNo, pageSize);
         
        return new ResponseEntity<List<Expense>>(list, new HttpHeaders(), HttpStatus.OK); 
    }

}