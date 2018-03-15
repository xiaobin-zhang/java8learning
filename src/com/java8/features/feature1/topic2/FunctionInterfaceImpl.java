package com.java8.features.feature1.topic2;

/**
 * <pre>
 * 函数式接口的使用：
 * 1、实现类必须重写接口的抽象方法
 * 2、如果实现类实现了多个函数式接口，也必须重写全部接口的抽象方法
 * 3、如果多个函数式接口中存在相同的默认方法，则必须重写该默认方法，
 *    在重写默认方法是，可以指定使用哪个接口中的方法，
 *    也可以全部不用，完全重写
 * </pre>
 * @author zhangxiaobin
 *
 */
public class FunctionInterfaceImpl implements FunctionInterfaceA, FunctionInterfaceB, FunctionInterfaceC {

	@Override
	public void defaultMethod2() {
		FunctionInterfaceA.super.defaultMethod2();
	}

	@Override
	public void defaultMethod1() {
		FunctionInterfaceB.super.defaultMethod1();
	}
	
	@Override
	public void defaultMethod3() {
		System.out.println("this is imple's override defaultMethod3");
	}

	@Override
	public void abstractMet() {
		System.out.println("impl class abstractMet");
	}

	@Override
	public void abstractMetC() {
		System.out.println("impl class abstractMet c");
	}

}
