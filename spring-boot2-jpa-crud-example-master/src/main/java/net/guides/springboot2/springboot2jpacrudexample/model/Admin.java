package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admins")
public class Admin {

	private long id;
	private String userName;
	private String emailId;
	private String passwordUser;

	public Admin() {
		
	}
	
	public Admin(String userName, String emailId, String passwordUser) {
		this.userName = userName;
		this.emailId = emailId;
		this.passwordUser = passwordUser;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "user_name", nullable = false)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	@Column(name = "email_address", nullable = false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

    @Column(name = "password_user", nullable = false)
	public String getPasswordUser() {
		return passwordUser;
	}
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	@Override
	public String toString() {
		return "Admin  [id=" + id + ", userName=" + userName + ", emailId=" + emailId + ", passwordUser=" + passwordUser
				+ "]";
	}
	
}
