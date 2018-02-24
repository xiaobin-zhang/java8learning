package com.java8.features.feature2;

/**
 * 接口中可以定义默认方法和静态方法。
 * @author zhangxiaobin
 *
 */
public interface DefaultInterfaceA {

	default void defaultMethod1() {
		System.out.println("DfInAM1");
	}
	
	default void defaultMethod2() {
		System.out.println("DfInAM2");
	}
	
	static void staticMethod() {
		System.out.println("DfInASm1");
	}
}
