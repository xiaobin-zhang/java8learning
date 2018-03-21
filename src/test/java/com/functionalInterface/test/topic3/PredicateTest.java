package com.functionalInterface.test.topic3;

import java.util.function.Predicate;

import com.time.test.User;

/**
 * 这个函数式接口被用来定义某些情形的检查，类似于断言
 * @author zhangxiaobin
 *
 */
public class PredicateTest {
	
	public static void main(String[] args) {
		User u = new User("zhangxiaobin", 18, "man");
		//非空检查
		Predicate<User> nullCheck = user -> user != null;
		//年龄检查
		Predicate<Integer> ageCheck = age -> age.compareTo(0) > 0;
		Predicate<Integer> ageCheck2 = age -> age.compareTo(100) < 0;
		//性别检查
		Predicate<String> sexCheck = sex -> sex.equals("man");
		//姓名检查
		Predicate<String> nameCheck = name -> name.equals("admin");
		//User校验
		Predicate<User> equalCheck = Predicate.isEqual(u);
		
		System.out.println(nullCheck.test(u));
		System.out.println(ageCheck.test(u.getAge()));
		System.out.println(sexCheck.test(u.getSex()));
		System.out.println(nameCheck.test(u.getName()));
		
		System.out.println(ageCheck.and(ageCheck2).test(u.getAge()));
		
		System.out.println(nameCheck.negate().test(u.getName()));
		
		System.out.println(nameCheck.or(sexCheck).test(u.getName()));
		
		System.out.println(equalCheck.test(u));
	}
}
