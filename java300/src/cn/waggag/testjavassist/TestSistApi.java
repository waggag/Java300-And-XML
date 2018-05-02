package cn.waggag.testjavassist;

import java.util.Arrays;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.compiler.MemberResolver.Method;

/**
 * 测试javassist的API
 * @author waggag
 * 2018年4月26日 下午7:55:37
 */
@SuppressWarnings("all")
public class TestSistApi {
	/**
	 * 测试类的基本用法
	 * @throws Exception 
	 */
	public static void test() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("cn.waggag.testjavassist.Emp");
		
		byte[] bytes = cc.toBytecode();
		System.out.println(Arrays.toString(bytes));
		//获取类的其他信息
		System.out.println(cc.getName());
		System.out.println(cc.getSimpleName());
		System.out.println(cc.getSuperclass());
	}
	/**
	 * 测试产生新的方法
	 * @throws Exception
	 */
	public static void test2() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("cn.waggag.testjavassist.Emp");
		
		//CtMethod m =CtNewMethod.make("public int add(int a, int b){return a+b;}", cc)
		System.out.println("=============================");
		CtMethod m = new CtMethod(CtClass.intType,"add",
				new CtClass[] {CtClass.intType,CtClass.intType},cc);
		m.setModifiers(Modifier.PUBLIC);
		m.setBody("{System.out.println(\"www.waggag.cn\");return $1+$2;}");
		cc.addMethod(m);
		
		//通过反射调用新生成的方法
		Class clazz = cc.toClass();
		Object obj = clazz.newInstance();
		java.lang.reflect.Method method = clazz.getDeclaredMethod("add", int.class, int.class);
		Object result = method.invoke(obj, 200, 300);
		System.out.println(result);
	}
	public static void main(String[] args) {
		try {
			test2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
