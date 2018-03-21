package com.functionalInterface.test.topic1;

/**
 * 函数式接口
 * @author zhangxiaobin
 *
 */
public class F1Topic1 {
	
	public static void method1() {
		FunctInterf f = new FunctInterfImplA();
		f.abstractMet();
	}
	
	public static void main(String[] args) {
		FunctInterf.staticMethod1();
		FunctInterf.staticMethod2();
		method1();
	}
}
