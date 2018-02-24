package com.java8.features.feature4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 流的生成.
 * @author zhangxiaobin
 *
 */
public class StreamTopic1 {

	//为集合创建串行流
	public static Stream<Integer> generateStream(List<Integer> list) {
		Stream<Integer> stream = list.stream();
		return stream;
	}
	
	//为集合创建并行流
	public static Stream<Integer> generateParStream(List<Integer> list) {
		Stream<Integer> parallelStream = list.parallelStream();
		return parallelStream;		
	}
	
	//映射每个元素到对应的结果
	public static Stream<Integer> mapStream(Stream<Integer> stream) {
		Stream<Integer> map = stream.map(u -> u + u);
		return map;
	}
	
	//迭代流中的每个数据
	public static void forEachStream(Stream<Integer> stream) {
		stream.forEach(System.out::println);
	}
	
	//通过设置的条件过滤出元素
	public static Stream<Integer> filterStream(Stream<Integer> stream) {
		Stream<Integer> filter = stream.filter(u -> u % 2 == 0);
		return filter;
	}
	
	//用于获取指定数量的流
	public static Stream<Integer> limitStream(Stream<Integer> stream) {
		Stream<Integer> limit = stream.limit(3);
		return limit;
	}
	
	//对流进行排序
	public static Stream<Integer> sortedAscStream(Stream<Integer> stream) {
		Stream<Integer> sorted = stream.sorted();
		return sorted;
	}
	
	//对流进行排序
	public static Stream<Integer> sortedDescStream(Stream<Integer> stream) {
		Stream<Integer> sorted = stream.sorted(Comparator.reverseOrder());
		return sorted;
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		generateStream(list);
		generateParStream(list);
		
		forEachStream(generateStream(list));
		forEachStream(generateParStream(list));
		
		forEachStream(sortedAscStream(generateStream(list)));
		forEachStream(sortedDescStream(generateStream(list)));
		
		forEachStream(limitStream(generateStream(list)));
		forEachStream(limitStream(generateParStream(list)));
		
		forEachStream(mapStream(generateStream(list)));
		forEachStream(mapStream(generateParStream(list)));
		
		forEachStream(filterStream(generateStream(list)));
		forEachStream(filterStream(generateParStream(list)));
		
	}
}
