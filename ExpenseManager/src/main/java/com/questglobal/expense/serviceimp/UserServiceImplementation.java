package com.questglobal.expense.serviceimp;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.questglobal.expense.daos.ExpenseDao;
import com.questglobal.expense.daos.UserDao;
import com.questglobal.expense.model.Expense;
import com.questglobal.expense.model.User;
import com.questglobal.expense.serviceinterface.UserService;



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
	public List<Expense> displayExpense(int userId){
		
		return expenseDao.findByUserId(userDao.findById(userId).get());
	}

	

	
	@Override
	public Expense editExpenseData(Integer expenseId) {
		
		Expense expense=expenseDao.findById(expenseId).get();
		
		return expense;
	}
	
	@Override
	public void deleteExpenseData(Integer expenseId) {
		expenseDao.deleteById(expenseId);
		
	}

	@Override
	public List<Expense> displayAllExpenseData() {
		
		return expenseDao.findAll();
	}
      
	@Override
	public List<Expense> getAllExpense(Integer userId,Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		 
        Page<Expense> pagedResult = expenseDao.findByUserId(userDao.findById(userId).get(),paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Expense>();
        }
	}

	
	
	

}
