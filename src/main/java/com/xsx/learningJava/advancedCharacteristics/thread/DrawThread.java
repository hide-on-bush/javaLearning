package com.xsx.learningJava.advancedCharacteristics.thread;

/**
 * @author Administrator
 * 取钱线程：
 */
public class DrawThread extends Thread {

	private Account account;//账号   
	private double drawAmount;//取钱金额     
	
	
	public DrawThread(String name, Account account, double drawAmount) {   
		//为线程取名字        
		super(name);        
		this.account = account;        
		this.drawAmount = drawAmount;    
	}     
	@Override    
	public void run() {       
		/*if (account.getBalance() >= drawAmount) {        
			System.out.println("吐出钞票:" + drawAmount);             
			account.setBalance(account.getBalance() - drawAmount);             
			System.out.println("余额为" + account.getBalance());         
		} else {    
			  System.out.println(getName()+ "取钱失败");     
		}   */  
		account.draw(drawAmount);
	}      
	public Account getAccount() {       
		  return account;   
	}    
	public void setAccount(Account account) {  
		this.account = account;  
	}    
	public double getDrawAmount() {     
		return drawAmount;   
	}    
	public void setDrawAmount(double drawAmount) {   
		this.drawAmount = drawAmount;    
	} 
}


		