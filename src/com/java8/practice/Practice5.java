package com.java8.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import com.java8.domain.User;

public class Practice5 {
	public static void main(String[] args) {
		User u1 = new User("liushishi",20,"女");
		User u2 = new User("wuqilong",40,"男");
		User u3 = new User("yangmi幂",21,"女");
		User u4 = new User("fanbinibn",21,"女");
		
		List<User> users = Arrays.asList(u1,u2,u3,u4);
		
		users.forEach(u -> System.out.println(u));
		
		System.out.println("======================");
		
		users.forEach(System.out::println);
		
		System.out.println("=======================");
		
		users.forEach(User::getName);
		
		System.out.println("*************************");
		
		Consumer<User> getAge = User::getAge;
		users.forEach(getAge);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		users.sort(Comparator.comparing(u -> u.getAge()));
		users.forEach(System.out::println);
		System.out.println("##########################");
		users.sort(Comparator.comparing(User::getAge));
		users.forEach(System.out::println);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^");
		
		users.sort(Comparator.comparingInt(User::getAge).reversed());
		users.forEach(System.out::println);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		Comparator<User> c = Comparator.comparing(User::getAge).thenComparing(User::getName);
		users.sort(c);
		users.forEach(System.out::println);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
		users.sort(Comparator.nullsLast(Comparator.comparing(User::getName)));
		users.forEach(System.out::println);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		Function<String, User> f = User::new;
		f.apply("huangxiaomin");
		
	}
}
