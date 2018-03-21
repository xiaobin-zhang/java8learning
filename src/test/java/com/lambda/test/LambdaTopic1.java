package com.lambda.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.time.test.User;

public class LambdaTopic1 {
	
	final int a = 1;
	
	static int b = 1;
	
	int c ;

	/**
	 * <pre>
	 * lambda表达式
	 * 可以访问外部的final类属性;
	 * 可以访问、修改外部静态类属性;
	 * 可以访问、修改外部普通类属性。
	 * <pre>
	 */
	Consumer<Integer> consumer = (x) -> {
//		this.a = 2;
		b = 2;
		this.c = x;
		System.out.println(this.a);
	};
	
	/**
	 * lambda表达式
	 * 可以访问外部方法的局部变量
	 * 不可以修改外部方法的局部变量
	 */
	public void lambda_test1() {
		int ma = 1;
		Consumer<Integer> fc = (x) -> {
		//	ma = 2;
			System.out.println(ma);
			System.out.println(x + ma);
		};
		fc.accept(ma);
	}
	
	/**
	 * 方法引用
	 */
	public void lambda_test2() {
		User u1 = new User("xiaobin", 18, "man");
		User u2 = new User("yangguang", 28, "man");
		User u3 = new User("tiantian", 38, "man");
		User u4 = new User("shuhai", 48, "man");
		//构造方法的引用
		Supplier<User> u = User::new;
		User user = u.get();
		//静态方法的引用
		Consumer<User> consumer = User::staticMet_2;
		consumer.accept(user);
		// 普通方法的引用
		Comparator<User> comparator = Comparator.comparing(User::getAge);
		List<User> users = Arrays.asList(u1, u2, u3, u4, user);
		users.sort(comparator);
		users.forEach(System.out::println);
	}
}
