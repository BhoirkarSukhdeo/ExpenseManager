package com.questglobal.expense.controllers;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import com.questglobal.expense.model.Expense;
import com.questglobal.expense.serviceinterface.ExpenseService;
@Component
@Path("/expenseController")
public class ExpenseController {
	
	
	 @Autowired
	 private  ExpenseService expenseService;
	 
	 Logger logger=LoggerFactory.getLogger(ExpenseController.class);
		
	 
	
	   @POST
	   @Path(value = "/add")
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.APPLICATION_JSON)
	   public ResponseEntity<Expense> add(Expense e)
	   {
		 logger.info("entet into add method of ExpenseController ");
		   Expense e1=expenseService.addExpenseData(e);
		   return new ResponseEntity<Expense>(e1,HttpStatus.OK);
	   }
	 
	   @GET
	   @Path("/display")
	   @Produces(MediaType.APPLICATION_JSON)
	   	public ResponseEntity<List<Expense>> getAllExpenseData()
		{
			logger.info("UserController :: getAllExpenseData method Call");
			List<Expense> expenseList=expenseService.displayAllExpenseData();
			return new ResponseEntity<List<Expense>>(expenseList,HttpStatus.OK);
		}
       
	   @GET
	   @Path(value = "/editExpenseData/{expenseId}")
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.APPLICATION_JSON)
		public ResponseEntity<Expense> editExpenseData(@PathParam(value = "expenseId") Integer expenseId)
		{
			logger.info("UserController :: editExpenseData method call");
			Expense expense=expenseService.editExpenseData(expenseId);
			if(expense==null)
				return new ResponseEntity<Expense>(HttpStatus.BAD_REQUEST);
			else
			return new ResponseEntity<Expense>(expense,HttpStatus.OK);
		} 
	   
	   @PUT
	   @Path(value = "/updateExpense")
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.APPLICATION_JSON)
		public ResponseEntity<Expense> updateExpenseData(Expense expense)
		{
	         
	     logger.error("UserController :: error occured at register page");  
	     Expense expenseData=expenseService.addExpenseData(expense);
	         
	       return new ResponseEntity<Expense>(expenseData,HttpStatus.OK);
		}
	   
	   @DELETE
	   @Path("/deleteExpenseData/{expenseId}")
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.APPLICATION_JSON)
		public ResponseEntity deleteExpenseData(@PathParam(value = "expenseId") Integer expenseId)
		{
		   logger.info("enter in to deleteExpenseData method of ExpenseControllre");
			expenseService.deleteExpenseData(expenseId);
			return new ResponseEntity(HttpStatus.OK);
		}
	   
}
