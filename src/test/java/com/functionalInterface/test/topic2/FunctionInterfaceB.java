package com.functionalInterface.test.topic2;

/**
 * 函数式接口B
 * @author zhangxiaobin
 *
 */
@FunctionalInterface
public interface FunctionInterfaceB {
	
	abstract void abstractMet();

	default void defaultMethod1() {
		System.out.println("DfInBM1");
	}
	
	default void defaultMethod2() {
		System.out.println("DfInBM2");
	}
	
	default void defaultMethod3() {
		System.out.println("DfInBM2");
	}
	
	static void staticMethod() {
		System.out.println("DfInBSm1");
	}
}
