package com.questglobal.expense.daos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.questglobal.expense.model.Expense;
import com.questglobal.expense.model.User;

@Repository
public interface ExpenseDao extends JpaRepository<Expense, Integer>{
	
	List<Expense> findByUserId(User userid);
	Page<Expense> findByUserId(User userid,Pageable page);
	
	

	
	
	

}
