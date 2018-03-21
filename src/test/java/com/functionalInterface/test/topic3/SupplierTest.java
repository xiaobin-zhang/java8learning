package com.functionalInterface.test.topic3;

import java.util.UUID;
import java.util.function.Supplier;

import com.time.test.User;

/**
 * 这个函数式接口不需要任何参数，却会产生一个值。这可以被用来生成唯一标志码
 * @author zhangxiaobin
 *
 */
public class SupplierTest {
	
	public static void main(String[] args) {
		User u = new User("zhangxiaobin", 18, "man");
		
		Supplier<String> s = () -> "hello";
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get());
		
		Supplier<User> s2 = () -> u;
		System.out.println(s2.get());
		System.out.println(s2.get());
		System.out.println(s2.get());
		
		Supplier<String> s3 = () -> UUID.randomUUID().toString();
		System.out.println(s3.get());
		System.out.println(s3.get());
		System.out.println(s3.get());
	}
}
