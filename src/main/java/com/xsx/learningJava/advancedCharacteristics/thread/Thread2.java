package com.xsx.learningJava.advancedCharacteristics.thread;

/**
 *实现多线程的方法二：实现Runnable接口 
 **/
public class Thread2 implements Runnable{

	private static Bank bank;//共享数据
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		
		synchronized (this) {
			if (bank == null) {
				bank = Bank.getNewBank();
			}
		   System.out.println(this);
		   System.out.println("线程名："+ Thread.currentThread().getName() + bank);
		}
		
	}
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Thread2());
		Thread thread2 = new Thread(new Thread2());
		thread1.setName("线程1");
		thread2.setName("线程2");
		thread1.start();
		thread2.start();
	}

}


class Bank {
	private static  Bank bank = null;
	private Bank() {
		
	}
	public static Bank getNewBank() {
		if (bank != null) {
			return bank;
		}
		else  {
			try {
				//当一个线程被挂起时，懒汉式实现单例会出现线程安全问题，可以使用同步方法或同步代码块,实现的方法实现多线程使用同步代码块时，锁为this
				Thread.currentThread().sleep(50000l);
				bank = new Bank();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return bank; 
	}
}
