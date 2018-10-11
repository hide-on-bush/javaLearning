package com.xsx.learningJava.designPattern.staticProxy;

public class TestProxy {

	public static void main(String[] args) {
		 LiuDeHua liuDeHua = new LiuDeHua();
		 Star star = new Proxy(liuDeHua);
		 star.sing();
	}
}
