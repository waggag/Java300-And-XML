package cn.waggag.testjavassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;

/**
 * 测试javassist生成一个新的类
 * @author waggag
 * 2018年4月26日 下午7:29:21
 */
public class TestJavassist {
	
	public static void main(String[] args) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("cn.waggag.Emp");
		
		//创建属性
		CtField f1 = CtField.make("private int pno;", cc);
		CtField f2 = CtField.make("private String name;", cc);
		cc.addField(f1);
		cc.addField(f2);
		//创建方法
		CtMethod m1 = CtMethod.make("public int getPno(){return pno;}", cc);
		CtMethod m2 = CtMethod.make("public void setPno(int pno){this.pno = pno;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		
		//创建构造器
		CtConstructor constructor = new CtConstructor(new CtClass[] {CtClass.intType, pool.get("java.lang.String")}, cc);
		constructor.setBody("{this.pno = pno; this.name = name;}");
		cc.addConstructor(constructor);
		//将生成的类存放到磁盘E:/myjava
		cc.writeFile("E:/myjava");
		System.out.println("生成类成功!");
	}
}
