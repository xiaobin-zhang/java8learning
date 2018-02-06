package com.java8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.java8.domain.User;

public class Practice1 {

	public static void main(String[] args) {
		User u1 = new User("刘诗诗",20,"女");
		User u2 = new User("吴奇隆",40,"男");
		User u3 = new User("杨幂",21,"女");
		
		List<User> users = Arrays.asList(u1,u2,u3);
		
		for (User user : users) {
			System.out.println(user.getName());
		}
		
		System.out.println("===========================");
		
		users.forEach(new Consumer<User>() {
			@Override
			public void accept(User u) {
				System.out.println(u.getName());
			}
		});
		
		System.out.println("++++++++++++++++++++++++++++++");
		
		users.forEach(u -> System.out.println(u.getName()));
		users.forEach(u -> u.toString());
	}
}
