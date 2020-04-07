package com.questglobal.expense.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId")
	private int userId;
	
	@Column(name="userName")
	@NotEmpty(message = " User Name Is Empty ")
	private String userName;
	
	@Column(name="userAddress")
	@NotEmpty(message = " User Address Is Empty ")
	private String userAddress;
	
	@Column(name="userEmail")
	@NotEmpty(message = " User Email Is Empty ")
	@Email(message = "@gmail.com")
	private String userEmail;
	
	@Column(name="userPassword")
	@NotEmpty(message = " User Password Is Empty ")
	@Size(min = 8)
	private String userPassword;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId",referencedColumnName = "userId")
	private List<Expense> expenseList;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	

	
}
