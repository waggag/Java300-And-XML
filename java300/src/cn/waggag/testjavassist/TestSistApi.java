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
 * ����javassist��API
 * @author waggag
 * 2018��4��26�� ����7:55:37
 */
@SuppressWarnings("all")
public class TestSistApi {
	/**
	 * ������Ļ����÷�
	 * @throws Exception 
	 */
	public static void test() throws Exception{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("cn.waggag.testjavassist.Emp");
		
		byte[] bytes = cc.toBytecode();
		System.out.println(Arrays.toString(bytes));
		//��ȡ���������Ϣ
		System.out.println(cc.getName());
		System.out.println(cc.getSimpleName());
		System.out.println(cc.getSuperclass());
	}
	/**
	 * ���Բ����µķ���
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
		
		//ͨ��������������ɵķ���
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
