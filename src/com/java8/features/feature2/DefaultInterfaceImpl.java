package com.java8.features.feature2;

public class DefaultInterfaceImpl implements DefaultInterfaceA, DefaultInterfaceB {

	@Override
	public void defaultMethod2() {
		DefaultInterfaceA.super.defaultMethod2();
	}

	@Override
	public void defaultMethod1() {
		DefaultInterfaceA.super.defaultMethod1();
	}

}
