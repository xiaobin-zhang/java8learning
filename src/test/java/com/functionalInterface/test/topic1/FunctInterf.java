package com.functionalInterface.test.topic1;

/**
 * <pre>
 * 函数式接口：
 * 1、函数式接口不允许是空接口,也不允许只有默认方法和静态方法
 * 2、如果有抽象方法，则只能有一个抽象方法
 * 3、抽象方法和普通方法在函数式接口中不允许共存
 * 4、可以有多个默认方法，默认方法必须要有方法体
 * 5、可以有多个静态方法，静态方法必须要有方法体,静态方法只能通过接口调用
 * </pre>
 * @author zhangxiaobin
 *
 */
@FunctionalInterface
public interface FunctInterf {

	//函数式接口中，有且只能有一个抽象方法
	abstract void abstractMet();
	
	default void defaultMethod1() {
		System.out.println("this is FunctionalInterface's default method 1");
	}
	
	default void defaultMethod2() {
		System.out.println("this is FunctionalInterface's default method 2");
	}
	
	static void staticMethod1() {
		System.out.println("this is FunctionalInterface's static method 1");
	}
	
	static void staticMethod2() {
		System.out.println("this is FunctionalInterface's static method 2");
	}
}
