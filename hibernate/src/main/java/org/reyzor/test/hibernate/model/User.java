package org.reyzor.test.hibernate.model;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable{
	
	private long id;
	
	private int age;
	
	private String firstname;
	private String lastname;
	
	private Set<Role> roles;

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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

	public User() {
		
	}
	
	public User(long id) {
		this.id = id;
	}

}
