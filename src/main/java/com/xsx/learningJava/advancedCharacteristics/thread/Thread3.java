package com.xsx.learningJava.advancedCharacteristics.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/**
 * 创建多线程的第三种方法：实现Callable接口，将实现Callable接口的实现类对象当做参数创建FutureTask对象，然后将此对象传入Thread构造函数，从而创建一个线程
 * 
 * 通过 Callable 和 Future 创建线程
      1. 创建 Callable 接口的实现类，并实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值。

      2. 创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值。

      3. 使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程。

      4. 调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值。
 ***/
public class Thread3 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		 //call()方法为改线程要实现的功能
		 int i = 0;  
	     for(; i < 100; i++)  {  
	            System.out.println(Thread.currentThread().getName()+" "+i);  
	        }  
	     return i;  
	}

	public static void main(String[] args) {
		//创建 Callable 接口的实现类
		Thread3 thread3 = new Thread3();
		Thread3 thread4 = new Thread3();
		//创建 FutureTask对象
		FutureTask<Integer> ft = new FutureTask<>(thread3);  
		FutureTask<Integer> ft1 = new FutureTask<>(thread4);
        for (int i = 0; i < 100; i++)  {  
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);  
            if(i == 20)  { 
            	//将FutureTask实例对象当参数传入Thread构造函数，从而创建一个线程
                new Thread(ft, "有返回值的线程").start();  
                new Thread(ft1, "线程2").start();
            }  
        }  
        try  {  
            System.out.println("子线程的返回值："+ ft.get());  
            System.out.println("线程2返回值："+ ft1.get());
        } catch (InterruptedException e)  {  
            e.printStackTrace();  
        } catch (ExecutionException e)  {  
            e.printStackTrace();  
        }  
	}
}
