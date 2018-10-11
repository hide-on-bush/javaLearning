package com.xsx.learningJava.designPattern.singleton;

/**懒汉式单例模式**/
public class SlackerSingleton {

	
	private SlackerSingleton() {
		
	}
	
	
	private static SlackerSingleton  instance = null;
	
	public static SlackerSingleton newInstance() {

		if (instance == null) {
			instance = new SlackerSingleton();
		}
		
		return instance;
	}
}
