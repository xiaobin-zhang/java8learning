package com.java8.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.java8.domain.User;

public class Practice3 {
	public static void main(String[] args) {
		User u1 = new User("刘诗诗",20,"女");
		User u2 = new User("吴奇隆",40,"男");
		User u3 = new User("杨幂",21,"女");
		
		List<User> users = Arrays.asList(u1,u2,u3);
		
		Consumer<User> mostraMensagem = u -> System.out.println("look at next example");
		
		Consumer<User> ex = u -> System.out.println(u.toString());
		
		users.forEach(mostraMensagem.andThen(ex));
		
		System.out.println("=====================================");
		
		ArrayList<User> users2 = new ArrayList<User>();
		users2.addAll(users);
		Predicate<User> predicado = new Predicate<User>(){

			@Override
			public boolean test(User u) {
				return u.getAge() == 20;
			}
			
		};
		
		users2.removeIf(predicado);
		users2.forEach(u -> System.out.println(u.toString()));
		
		System.out.println("+++++++++++++++++++++++++++++++++++");
		
		users2.removeIf(u -> u.getSex().equals("女"));
		users2.forEach(u -> System.out.println(u.toString()));
	} 
}
