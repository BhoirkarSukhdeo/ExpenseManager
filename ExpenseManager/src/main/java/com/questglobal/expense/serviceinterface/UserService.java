package com.questglobal.expense.serviceinterface;

import java.util.List;



import com.questglobal.expense.model.Expense;
import com.questglobal.expense.model.User;

public interface UserService {

	public User addUserDetails(User user);
	public User findByUserEmailAndUserPassword(String userEmail,String userPassword);
	public List<Expense> displayExpense();
}
