package com.java8.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import com.java8.domain.User;

public class Practice4 {
	public static void main(String[] args) {
		User u1 = new User("liushishi",20,"女");
		User u2 = new User("wuqilong",40,"男");
		User u3 = new User("dilireba",21,"女");
		
		List<User> users = Arrays.asList(u1,u2,u3);
		
		System.out.println(users);
		System.out.println("=======================");
		Comparator<User> comparator = new Comparator<User>(){

			@Override
			public int compare(User o1, User o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		};
		Collections.sort(users, comparator);
		System.out.println(users);
		System.out.println("++++++++++++++++++++++");
		users.sort(comparator);
		System.out.println(users);
		System.out.println("**********************");
		
		Comparator<User> comparatorLambda = (c1, c2) -> c2.getName().compareTo(c1.getName());
		Collections.sort(users, comparatorLambda);
		System.out.println(users);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&");
		users.sort((c1,c2) -> c1.getName().compareTo(c2.getName()));
		System.out.println(users);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^");
		users.sort(Comparator.comparing( u -> u.getName()));
		System.out.println(users);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
		
		List<String> list = Collections.emptyList();
		list.sort(Comparator.comparing((String s) -> s.toString()).thenComparing(s -> s.length()));
		
		Function<User, Integer> extraiAges = u -> u.getAge();
		Comparator<User> comparator3 = Comparator.comparing(extraiAges);
		users.sort(comparator3);
		System.out.println(users);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");
		
		ToIntFunction<User> extraiAges2 = u ->u.getAge();
		Comparator<User> comparator4 = Comparator.comparingInt(extraiAges2);
		users.sort(comparator4);
		System.out.println(users);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$");
		
		users.sort(Comparator.comparingInt( u -> u.getAge()));
		System.out.println(users);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		List<String> palavras = Arrays.asList("albab","taobao","zhibubao");
		palavras.sort(Comparator.naturalOrder());
		System.out.println(palavras);
		palavras.sort(Comparator.reverseOrder());
		System.out.println(palavras);
	}
}
