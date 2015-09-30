package com.cmad.database;

public class User {
	
	private int id;
	private String fullname;
	private String email;
	private String password;
	private String gender;
	private String birthdate;
	
	public User(){
		
	}
	
	public User(String fullname, String email, String password,String gender, String birthdate) {
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birthdate = birthdate;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", email=" + email
				+ ", gender=" + gender + ", birthdate=" + birthdate + "]";
	}
	
	
	
}
