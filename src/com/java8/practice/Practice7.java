package com.java8.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.java8.domain.User;

public class Practice7 {

	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		users.add(new User("小斌", 18, "男"));
		users.add(new User("小芳", 21, "女"));
		users.add(new User("小吴", 30, "男"));
		users.add(new User("小李", 20, "男"));
		users.add(new User("小美", 18, "女"));
		
		List<String> collect = users.stream()
									.filter(u -> u.getSex().equals("女"))
									.sorted(Comparator.comparingInt(User::getAge).reversed())
									.map(u -> u.getName())
									.collect(Collectors.toList());
		System.out.println(collect);
		
		System.out.println("=================");
		
		List<Integer> arrays = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> collect2 = arrays.stream()
										.filter(a -> {
											System.out.println("filter : " + a);
											return a % 2 == 0;
											})
										.map(a -> {
											System.out.println("map : " + a);
											return a * a;
											})
										.limit(2)
										.collect(Collectors.toList());
		System.out.println(collect2);
		
		System.out.println("==================");
		
		int a = 0b0010;
		String binaryString = Integer.toBinaryString(~a);
		System.out.println(binaryString);
		System.out.println(Integer.parseInt(binaryString, 2));
	}
}
