package com.xsx.learningJava.designPattern.singleton;

import java.util.concurrent.locks.ReentrantLock;

public class TestSingleton {
    
	//定义对象锁
	private static final ReentrantLock lock = new ReentrantLock();
	
	public static SlackerSingleton getSingleton () {
		lock.lock();
		
		try {
			return SlackerSingleton.newInstance();
		} finally {
			lock.unlock();
		}
		
	}
	
	
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("当前线程为：" + Thread.currentThread().getName() + getSingleton());
				
			}
		};
		
		
		Thread t1 = new Thread(r, "线程1");
		Thread t2 = new Thread(r, "线程2");
		t1.start();
		t2.start();
		
		
	}
	
	
	
	
}
