package com.vaishnavi.database.model;

public class Template {

	// create as per requirment, add variables, empty contructor, parametrised
	// const, and getters and setter
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String state;
	private String country;
	private Integer age;  // use only wrapper classes like Integer, Double etc..

	public Template() {
		super();
	}

	public Template(String firstname, String lastname, String email, String password, String state, String country,
			Integer age) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.state = state;
		this.country = country;
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Template [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password="
				+ password + ", state=" + state + ", country=" + country + ", age=" + age + "]";
	}

}
