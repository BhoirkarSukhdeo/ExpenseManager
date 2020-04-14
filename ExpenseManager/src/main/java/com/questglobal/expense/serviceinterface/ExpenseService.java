package com.questglobal.expense.serviceinterface;

import java.util.List;

import com.questglobal.expense.model.Expense;

public interface ExpenseService {

	
	public Expense addExpenseData(Expense expense);
	public List<Expense> displayAllExpenseData();
	public Expense editExpenseData(Integer expenseId);
	public void deleteExpenseData(Integer expenseId);
}
