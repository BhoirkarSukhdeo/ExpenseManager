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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

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
	@NotNull
	private float amount;
	
	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date date;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "expenseId",referencedColumnName = "expenseId")
	private List<Category> category;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="userId")
	private User userId;
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

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
	

}
