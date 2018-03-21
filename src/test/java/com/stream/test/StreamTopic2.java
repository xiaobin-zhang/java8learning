package com.stream.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.time.test.User;

/**
 * 流的生成.
 * @author zhangxiaobin
 *
 */
/**
 * Stream API:
 * filter: 过滤，允许指定一个断言来从数据流中排除一些元素。 Predicate<T>
 * sorted: 排序，允许指定一个比较器来对数据流进行排序。 Comparator<T>
 * map:	需要一个实现了Function<? super T, ? extends R>接口的lambda表达式来将一个数据流转化为另一个数据流.
 * distinct: 去重，方法将一个数据流转化成另一个没有重复元素的数据流，它使用对象的equals方法来决定对象是否相等
 * limit: 可以用来将结果集限定为特定的大小。limit方法是一个逻辑短路操作，也就是说它不会遍历所有的元素来得到结果。
 * skip : 跳过，可以和limit结合使用来创建分页
 * count: 这是一个结束操作。用来统计数量
 * collect:	这是一个结束操作.collect(Collectors.toList())将结果集中的信息放入列表
 * @author zhangxiaobin
 *
 */
public class StreamTopic2 {
	
	/**
	 * 用stream操作集合
	 * @param users
	 */
	public static void streamTest1(List<User> users) {
		List<String> names = users.stream()
									.filter(u -> u.getSex().equals("man"))
									.sorted(Comparator.comparing(User::getAge))
									.map(User::getName)
									.collect(Collectors.toList());
		names.forEach(System.out::println);
	}
	
	/**
	 * 使用distinct去重
	 * @param users
	 */
	public static void streamTest2(List<User> users) {
		List<String> names = users.stream()
									.filter(u -> u.getSex().equals("man"))
									.sorted(Comparator.comparing(User::getAge))
									.map(User::getName)
									.distinct()
									.collect(Collectors.toList());
		names.forEach(System.out::println);
	}
	
	/**
	 * 使用limit限制结果集大小，短路操作
	 * @param users
	 */
	public static void streamTest3(List<User> users) {
		List<String> names = users.stream()
									.filter(u -> u.getSex().equals("man"))
									.sorted(Comparator.comparing(User::getAge))
									.map(User::getName)
									.distinct()
									.limit(3)
									.collect(Collectors.toList());
		names.forEach(System.out::println);
	}
	
	/**
	 * 使用skip和limit实现分页.
	 * @param users		用户列表
	 * @param pageNo	页码
	 * @param itemNum	每页条数
	 */
	public static void streamTest4(List<User> users, Integer pageNo, Integer itemNum) {
		List<String> names = users.stream()
									.filter(u -> u.getSex().equals("man"))
									.sorted(Comparator.comparing(User::getAge))
									.map(User::getName)
									.distinct()
									.skip(pageNo * itemNum)
									.limit(itemNum)
									.collect(Collectors.toList());
		names.forEach(System.out::println);
	}
	
	/**
	 * 使用count统计数量
	 * @param users
	 */
	public static void streamTest5(List<User> users) {
		long count = users.stream()
							.filter(u -> u.getSex().equals("man"))
							.sorted(Comparator.comparing(User::getAge))
							.map(User::getName)
							.distinct()
							.count();
		System.out.println(count);
	}
	
	/**
	 * 使用flatMap进行流合并
	 * @param users
	 */
	public static void streamTest6(List<User> users) {
		Function<User, Stream<String>> function = user -> user.getHobbys().stream();
		List<String> collect = users.stream().flatMap(function).distinct().collect(Collectors.toList());
		collect.forEach(System.out::println);
	}
	
	/**
	 * 用allMatch、anyMatch、findFirst和findAny来检查数据集中元素的某一属性是否符合要求
	 * @param users
	 */
	public static void streamTest7(List<User> users) {
		Predicate<User> predicate = user -> user.getHobbys() != null;
		boolean allMatch = users.stream().allMatch(predicate);
		System.out.println(allMatch);
		
		boolean anyMatch = users.stream().anyMatch(user -> user.getAge() == 18);
		System.out.println(anyMatch);
		
		Optional<User> findFirst = users.stream().findFirst();
		User user = findFirst.get();
		System.out.println(user);
		
		Optional<User> findAny = users.stream().findAny();
		System.out.println(findAny.get());
	}
	
	public static void streamTest8(List<User> users) {
		String string = users.stream().map(User::getName).reduce((a, b) -> a + " " + b).get();
		System.out.println(string);
	}
	
	public static void main(String[] args) {
		;
		User user1 = new User("xiaobin", 18, "man", Arrays.asList("游泳", "滑雪", "蹦极", "跳伞"));
		User user1_cp = new User("xiaobin", 18, "man", Arrays.asList("游泳", "滑雪", "蹦极", "跳伞"));
		User user2 = new User("anshi", 38, "man", Arrays.asList("盖房子", "买房子", "买地皮", "拆房子"));
		User user3 = new User("mayun", 48, "man", Arrays.asList("吹牛", "鸡汤", "演讲", "吹口哨"));
		User user4 = new User("huateng", 42, "man", Arrays.asList("抄袭", "借鉴", "copy", "收购"));
		User user5 = new User("yanhong", 44, "man", Arrays.asList("掉队", "探险", "AI"));
		User user6 = new User("mingzhu", 54, "woman", Arrays.asList("发火", "生气", "骂人", "甩脸"));
		User user7 = new User("piaoxiaojie", 74, "woman", Arrays.asList("被弹劾", "不认罪", "爱咋咋的", "被坑"));
		User user8 = new User("meiyi", 64, "woman", Arrays.asList("wat", "wat", "wat", "wat"));
		List<User> users = Arrays.asList(user1, user1_cp, user2, user3, user4, user5, user6, user7, user8);
		
//		streamTest1(users);
		
//		streamTest2(users);
		
//		streamTest3(users);
		
//		streamTest4(users, 0, 2);
		
//		streamTest5(users);
		
//		streamTest6(users);
		
//		streamTest7(users);
		
		streamTest8(users);
	}
}
