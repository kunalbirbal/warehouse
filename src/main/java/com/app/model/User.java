package com.app.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="usertab")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="usrid")
	private Integer userId;
	
	@Column(name="usrname")
	private String userName;
	
	@Column(name="usremail")
	private String userEmail;
	
	@Column(name="usrpwd")
	private String userPassword;
	
	@Column(name="usrcontact")
	private String userContact;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="usr_roles_tab",
		joinColumns=@JoinColumn(name="usrid")
	)
	@Column(name="data")
	private Set<String> userRoles;
	
	public User() {
		super();
	}

	public User(Integer userId) {
		super();
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public Set<String> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<String> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userContact=" + userContact + ", userRoles=" + userRoles + "]";
	}

}
