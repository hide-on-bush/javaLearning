package com.xsx.learningJava.designPattern.staticProxy;

/**
 * 代理类：实现被代理类相同的接口，且关联一个被代理对象
 * **/
public class Proxy  implements Star{

	private LiuDeHua liuDeHua;
	
	public Proxy() {
		
	}
	
	
    public Proxy(LiuDeHua liuDeHua) {
		this.liuDeHua = liuDeHua;
	}

	@Override
	public void sing() {
		//实际调用的是被代理类的方法
		liuDeHua.sing();
	}

}
