package com.questglobal.expense.serviceinterface;

import java.util.List;



import com.questglobal.expense.model.Expense;
import com.questglobal.expense.model.User;

public interface UserService {

	public User addUserDetails(User user);
	public User findByUserEmailAndUserPassword(String userEmail,String userPassword);
	public List<Expense> displayExpense(int UserId);
	public Expense addExpenseData(Expense expense);
	public Expense editExpenseData(Integer expenseId);
	public void deleteExpenseData(Integer expenseId);
	public List<Expense> getAllExpense(Integer userId,Integer pageNo,Integer pageSize);

	
}
