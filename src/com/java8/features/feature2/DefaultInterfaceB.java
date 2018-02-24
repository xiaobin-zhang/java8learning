package com.java8.features.feature2;

public interface DefaultInterfaceB {

	default void defaultMethod1() {
		System.out.println("DfInBM1");
	}
	
	default void defaultMethod2() {
		System.out.println("DfInBM2");
	}
}
