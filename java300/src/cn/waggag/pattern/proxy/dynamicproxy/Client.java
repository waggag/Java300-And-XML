package cn.waggag.pattern.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		RealStar realStar = new RealStar();
		
		StarHander hander = new StarHander(realStar);
		
		Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {Star.class}, hander);
		
		proxy.sing();
	}
}
