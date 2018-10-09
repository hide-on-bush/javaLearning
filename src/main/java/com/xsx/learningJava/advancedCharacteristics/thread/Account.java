package com.xsx.learningJava.advancedCharacteristics.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行卡账号 
 * 使用锁来解决线程安全问题：ReentrantLock可重入锁
 * 1.定义锁对象；2：构造线程安全的方法即线程实现的功能；3在run()调用该线程安全的方法即可
 * 
 * 可重入锁，就是一个线程在获取了锁之后，再次去获取了同一个锁，这时候仅仅是把状态值进行累加。如果线程A释放了一次锁，减去状态值，其值为A线程第一次获取锁时的状态值
 * **/

public class Account {

	private String accountNum;//银行卡账号
	private double balance;//余额
	 
	//定义锁对象
    private final ReentrantLock lock = new ReentrantLock();
	 
	public Account() {
		super();
	}

	public Account(String accountNum, double balance) {
		super();
		this.accountNum = accountNum;
		this.balance = balance;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNum == null) ? 0 : accountNum.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNum == null) {
			if (other.accountNum != null)
				return false;
		} else if (!accountNum.equals(other.accountNum))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}

	//提供一个线程安全的draw方法Laura取钱   
	public void draw(double drawAmount) {
		    //获取锁
			lock.lock();       
			//使用try finally 保证所一定会被释放      
			try {          
				if (balance >= drawAmount) {  
					System.out.println("吐出钞票:" + drawAmount);        
					balance = balance- drawAmount;                
					System.out.println("余额为:" + balance);     
				} else {   
					System.out.println(Thread.currentThread().getName()+ "取钱失败");     
				}       
			} finally {   
				//释放锁
				lock.unlock();     
			}
		}

		
		

	
}
