package com.java8.features.feature2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;

import com.java8.domain.User;

/**
 * Lambda表达式.
 * @author zhangxiaobin
 *
 */
public class LambdaTopic {
	
	/**
	 * 不使用java8的一般方法
	 * @param users
	 * @return
	 */
	public static List<String> mansList(List<User> users) {
        List<String> mans = new ArrayList<>();
        for (User user : users) {
            if (user.getSex().equals("man")) {
            	mans.add(user.getName());
            }
        }
        return mans;
    }
	
	/**
	 * 使用Predicate<T> 来过滤集合
	 * @param users
	 * @return
	 */
	public static List<String> mansList_1(List<User> users) {
        List<String> mans = new ArrayList<>();
        Predicate<User> predicate = user -> user.getSex().equals("man");
        for (User user : users) {
            if (predicate.test(user)) {
            	mans.add(user.getName());
            }
        }
        return mans;
    }
	
	/**
	 * 使用Function<T, R> 来提取结果
	 * @param users
	 * @return
	 */
	public static List<String> mansList_2(List<User> users) {
		List<String> mans = new ArrayList<>();
        Predicate<User> predicate = user -> user.getSex().equals("man");
        Function<User, String> function = User::getName;
        for (User user : users) {
            if (predicate.test(user)) {
            	mans.add(function.apply(user));
            }
        }
        return mans;
	}

	public static void main(String[] args) {
		List<User> users = Arrays.asList(new User("xiaobin", 18, "man"), new User("xiaohong", 18, "woman"));
		List<String> mans = mansList(users);
		mans.forEach(System.out::println);
		
		List<String> mansList_1 = mansList_1(users);
		mansList_1.forEach(System.out::println);
		
		List<String> mansList_2 = mansList_2(users);
		mansList_2.forEach(System.out::println);
	}
}

