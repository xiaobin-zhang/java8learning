package com.java8.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class User {

	private String name;
	private int age;
	private String sex;
	public User() {
		super();
	}
	public User(String name) {
		super();
		this.name = name;
	}
	public User(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
}

class Users {
	private Set<User> users = new HashSet<User>();
	
	@SuppressWarnings("unused")
	private void addUser(User u) {
		this.users.add(u);
	}
	
	public Set<User> getUsers(){
		return Collections.unmodifiableSet(this.users);
	}
}
