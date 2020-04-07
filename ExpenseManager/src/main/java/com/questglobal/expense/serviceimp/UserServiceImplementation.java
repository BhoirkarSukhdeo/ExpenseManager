package com.questglobal.expense.serviceimp;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questglobal.expense.daos.ExpenseDao;
import com.questglobal.expense.daos.UserDao;
import com.questglobal.expense.model.Expense;
import com.questglobal.expense.model.User;
import com.questglobal.expense.serviceinterface.UserService;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ExpenseDao expenseDao;

	@Override
	public User addUserDetails(User user) {
	return	userDao.save(user);
		
	}

	@Override
	public User findByUserEmailAndUserPassword(String userEmail, String userPassword) {
		
		User user=userDao.findByUserEmailAndUserPassword(userEmail, userPassword);
		if(user==null)
			 throw new EntityNotFoundException("User Not Found");
		else
			return user;
			
	}

	@Override
	public List<Expense> displayExpense(){
	
		return expenseDao.findAll();
	}
      
	
	

}
