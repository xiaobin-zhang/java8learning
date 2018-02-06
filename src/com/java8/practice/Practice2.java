package com.java8.practice;

public class Practice2 {

	public static void main(String[] args) {
		Runnable r1 = new Runnable(){
			public void run (){
				for(int i=0;i<10;i++){
					System.out.println(i);
				}
			}
		};
		new Thread(r1).start();
		
		System.out.println("==========================");
		
		Runnable r2  = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		};
		new Thread(r2).start();
		
		System.out.println("+++++++++++++++++++++++++++++");
		
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		}).start();
		
		System.out.println("*******************************");
		
		
	}
}
