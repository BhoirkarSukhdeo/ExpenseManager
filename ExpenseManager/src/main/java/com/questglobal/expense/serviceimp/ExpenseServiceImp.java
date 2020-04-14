package com.questglobal.expense.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questglobal.expense.daos.ExpenseDao;
import com.questglobal.expense.model.Expense;
import com.questglobal.expense.serviceinterface.ExpenseService;
@Service
public class ExpenseServiceImp implements ExpenseService {
	
	@Autowired
	private ExpenseDao expenseDao;

	@Override
	public Expense addExpenseData(Expense expense) {
		
		return expenseDao.save(expense);
	}
	@Override
	public List<Expense> displayAllExpenseData() {
		
		return expenseDao.findAll();
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

	
}
