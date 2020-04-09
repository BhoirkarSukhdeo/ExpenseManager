package com.questglobal.expense.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categoryId")
	private int categoryId;
	

	@Column(name="categoryValues")
	@NotEmpty(message = " Category Value Is Empty ")
	private String categoryValues;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryValues() {
		return categoryValues;
	}

	public void setCategoryValues(String categoryValues) {
		this.categoryValues = categoryValues;
	}
}
