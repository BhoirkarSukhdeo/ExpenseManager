package com.questglobal.expense.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.questglobal.expense.model.Expense;

@Repository
public interface ExpenseDao extends JpaRepository<Expense, Integer>{
	
	

}
