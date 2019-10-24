package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	private long id;
	private String userName;
	private String jenisKelamin;
	private String alamatTinggal;
    private String emailId;
	private String passwordUser;
	
	public Customer() {
		
	}
	
	public Customer(String userName, String jenisKelamin, String alamatTinggal, String emailId, String passwordUser ) {
		this.userName = userName;
		this.jenisKelamin = jenisKelamin;
		this.alamatTinggal = alamatTinggal;
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
	
	@Column(name = "jenis_kelamin", nullable = false)
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

    @Column(name = "alamat_tinggal", nullable = false)
	public String getAlamatTinggal() {
		return alamatTinggal;
	}
	public void setAlamatTinggal(String alamatTinggal) {
		this.alamatTinggal = alamatTinggal;
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
		return "Customer  [id=" + id + ", userName=" + userName + ", jenisKelamin=" + jenisKelamin +  ", alamatTinggal=" + alamatTinggal +", emailId=" + emailId
				+ ", passwordUser=" + passwordUser +"]";
	}
	
}
