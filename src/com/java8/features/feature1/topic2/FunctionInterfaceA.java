package com.java8.features.feature1.topic2;

/**
 * 函数式接口A
 * @author zhangxiaobin
 *
 */
@FunctionalInterface
public interface FunctionInterfaceA {
	
	abstract void abstractMet();

	default void defaultMethod1() {
		System.out.println("DfInAM1");
	}
	
	default void defaultMethod2() {
		System.out.println("DfInAM2");
	}
	
	default void defaultMethod3() {
		System.out.println("DfInAM2");
	}
	
	static void staticMethod() {
		System.out.println("DfInASm1");
	}
}
