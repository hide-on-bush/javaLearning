package com.xsx.learningJava.advancedCharacteristics.thread;

/**
 * 试下多线程的方法一：集成Thread类，重写其run方法，在run()中编写该线程所要完成的功能，使用start()启动该线程
 **/
 class Thread1 extends Thread{

	private Ticket ticket = new Ticket();
	
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
			ticket.sellTicket();
	}
	
	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread1 thread2 = new Thread1();
		thread1.start();
		thread2.start();
		thread1.setName("线程1");
		thread2.setName("线程2");
	}
	
}

class Ticket {
	public static int ticket = 100;
	public synchronized void sellTicket() {
		   for (int i = 0 ; i <= 100 ; i++) {
			   ticket--;
			   System.out.println("当前线程为:" + Thread.currentThread().getName() + ";剩余车票：" + ticket+ " i = " + i);
			   if (ticket < 1)  {
				   break;
			   }
		   }
			
	}
}

