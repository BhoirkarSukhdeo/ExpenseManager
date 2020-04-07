package com.questglobal.expense.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="expenseId")
	private int expenseId;
	
	@Column(name="expenseTitle")
	@NotEmpty(message = " Expense Title Is Empty ")
	private String expenseTitle;
	
	@Column(name="description")
	@NotEmpty(message = " Description Is Empty ")
    private String description;
	
	@Column(name="amount")
	@NotEmpty(message = " Amount Is Empty ")
	private float amount;
	
	@Column(name="date")
	@NotEmpty(message = " Date Is Empty ")
	private Date date;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "expenseId",referencedColumnName = "expenseId")
	private List<Category> category;

	public int getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	public String getExpenseTitle() {
		return expenseTitle;
	}

	public void setExpenseTitle(String expenseTitle) {
		this.expenseTitle = expenseTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
	

}
