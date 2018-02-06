package com.java8.features.feature1;

/**
 * 函数式接口
 * @author zhangxiaobin
 *
 */
public class F1Topic1 {

	public static void main(String[] args) {
		FunctInterf functInterf = new FunctInterf() {
			@Override
			public void defaultMet() {
				System.out.println("this is customized functionalInterface");
			}
		};
		functInterf.defaultMet();
	}
}
