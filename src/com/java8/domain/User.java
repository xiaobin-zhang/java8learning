package com.java8.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

	private String name;
	private int age;
	private String sex;
	private List<String> hobbys;
	public User() {
		super();
	}
	public User(String name) {
		super();
		this.name = name;
	}
	
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public User(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public User(String name, int age, String sex, List<String> hobbys) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.hobbys = hobbys;
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
	public List<String> getHobbys() {
		return hobbys;
	}
	public void setHobbys(List<String> hobbys) {
		this.hobbys = hobbys;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", sex=" + sex + ", hobbys=" + hobbys + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj != null) {
			if (this.getClass().getName().equals(obj.getClass().getName())) {
				User user = (User) obj;
				isEquals = this.age == user.age && this.name.equals(user.name) && this.sex.equals(user.sex);
			}
		}
		return isEquals;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = result * 31 + this.age;
		result = result * 31 + this.name.hashCode();
		result = result * 31 + this.sex.hashCode();
		return result;
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
