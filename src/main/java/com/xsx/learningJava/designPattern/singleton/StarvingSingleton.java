package com.xsx.learningJava.designPattern.singleton;

/**单例模式之饿汉式**/
public class StarvingSingleton {

	private StarvingSingleton() {
		
	}
	private static StarvingSingleton instance = new StarvingSingleton();
	
	public static StarvingSingleton newInstance() {
		if (instance == null) {
			instance = new StarvingSingleton();
		}
		return instance;
	}
}
