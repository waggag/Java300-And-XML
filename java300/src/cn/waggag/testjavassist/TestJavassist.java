package cn.waggag.testjavassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;

/**
 * ����javassist����һ���µ���
 * @author waggag
 * 2018��4��26�� ����7:29:21
 */
public class TestJavassist {
	
	public static void main(String[] args) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("cn.waggag.Emp");
		
		//��������
		CtField f1 = CtField.make("private int pno;", cc);
		CtField f2 = CtField.make("private String name;", cc);
		cc.addField(f1);
		cc.addField(f2);
		//��������
		CtMethod m1 = CtMethod.make("public int getPno(){return pno;}", cc);
		CtMethod m2 = CtMethod.make("public void setPno(int pno){this.pno = pno;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		
		//����������
		CtConstructor constructor = new CtConstructor(new CtClass[] {CtClass.intType, pool.get("java.lang.String")}, cc);
		constructor.setBody("{this.pno = pno; this.name = name;}");
		cc.addConstructor(constructor);
		//�����ɵ����ŵ�����E:/myjava
		cc.writeFile("E:/myjava");
		System.out.println("������ɹ�!");
	}
}
