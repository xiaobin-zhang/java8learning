package com.java8.features.feature3;

import java.util.function.Consumer;

import com.java8.domain.User;

/**
 * Lambda表达式.
 * @author zhangxiaobin
 *
 */
public class LambdaTopic {

	public static void topic1() {
		Consumer<User> u = User::getAge;
		System.out.println(u);
	}
	
	public static void main(String[] args) {
		topic1();
	}
}
