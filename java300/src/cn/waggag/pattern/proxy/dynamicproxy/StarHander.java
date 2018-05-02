package cn.waggag.pattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHander implements InvocationHandler{
	Star realStar;

	public StarHander(Star realStar) {
		super();
		this.realStar = realStar;
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) 
			throws Throwable {
		System.out.println("代理之前的处理");
		
		realStar.sing(); 
		
		System.out.println("代理之后的处理");
		return null;
	}

}
