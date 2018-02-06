package com.java8.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.java8.domain.User;

public class Practice6 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		User u1 = new User("liushishi",20,"女");
		User u2 = new User("wuqilong",40,"男");
		User u3 = new User("yangmi幂",21,"女");
		User u4 = new User("fanbinibn",21,"女");
		
		List<User> users = Arrays.asList(u1,u2,u3,u4);
		
		Stream<User> userstream = users.stream().filter(u -> u.getAge() > 20);
		userstream.forEach(System.out::println);
		
		Supplier<ArrayList<User>> supplier = ArrayList::new;
		BiConsumer<ArrayList<User>, User> accumulator = ArrayList::add;
		BiConsumer<ArrayList<User>, ArrayList<User>> combiner  = ArrayList::addAll;
		
	}
}
