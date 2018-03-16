package com.java8.features.feature1.topic3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.java8.domain.User;

/**
 * 接受一定数量的参数 同时提供一个返回结果
 * @author zhangxiaobin
 *
 */
public class FunctionTest {
	
	/**
	 * Function<T, R>:接受一种类型(T)的参数,返回R类型的结果
	 */
	public static void Function_Test() {
		User u = new User("zhangxiaobin", 18, "man");
		
		Function<String, String> function = str -> str.toUpperCase();
		Function<String, Integer> function2 = str -> str.length();
		String apply = function.apply("hello world");
		Integer apply2 = function2.apply("hello world");
		System.out.println(apply);
		System.out.println(apply2);
		
		Function<User, String> function3 = user -> user.toString();
		String apply3 = function3.apply(u);
		System.out.println(apply3);
		
		Function<String, Integer> function4 = String::length;
		Integer apply4 = function4.apply("hello world");
		System.out.println(apply4);
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Function<List<Integer>, Integer> getMax = Collections::max;
		Integer apply5 = getMax.apply(list);
		System.out.println(apply5);
	}
	
	/**
	 * BiFunction<T,U,R>:接受两种类型(T,U)的参数,返回R类型的结果
	 */
	public static void BiFunction_Test() {
		BiFunction<String, Integer, User> biFunction = (name, age) -> new User(name, age);
		User apply = biFunction.apply("zhoujielun", 30);
		System.out.println(apply);
	}

	public static void main(String[] args) {
//		Function_Test();
		BiFunction_Test();
	}
}
