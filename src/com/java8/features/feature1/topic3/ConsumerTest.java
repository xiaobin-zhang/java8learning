package com.java8.features.feature1.topic3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import com.java8.domain.User;

/**
 * 这个函数式接口被用来执行一些不用产生输出的动作
 * @author zhangxiaobin
 *
 */
public class ConsumerTest {
	
	public static void changeName(User u) {
		u.setName("zhoujielun");
	}

	public static void main(String[] args) {
		User u = new User("zhangxiaobin", 18, "man");
		Consumer<User> consumer = user -> System.out.println(user.toString());
		consumer.accept(u);
		Consumer<User> consumer2 = user -> user.setAge(user.getAge() + 1);
		consumer.andThen(consumer2).accept(u);
		consumer2.andThen(consumer).accept(u);
		Consumer<User> consumer3 = user -> ConsumerTest.changeName(user);
		consumer3.andThen(consumer).accept(u);
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Consumer<List<Integer>> consumer4 = Collections::reverse;
		consumer4.accept(list);
		System.out.println(list);
	} 
}
