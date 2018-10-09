package com.xsx.learningJava.advancedCharacteristics.thread;

public class DrawTest {

	public static void main(String[] args) {     
		  Account account = new Account("123456", 1000);     
		  DrawThread DrawThread1 = new DrawThread("甲", account, 800);      
		  DrawThread DrawThread2 = new DrawThread("乙", account, 800); 
		  //设置线程的优先级
		  DrawThread1.setPriority(Thread.MIN_PRIORITY);
		  DrawThread2.setPriority(Thread.MAX_PRIORITY);
		  DrawThread1.start();
		  DrawThread2.start();
	  }
}
