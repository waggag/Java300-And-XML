package Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * ʹ�÷����ȡע�����Ϣ,ģ�⴦��ע����Ϣ������
 * @author waggag
 * 2018��4��23�� ����8:16:08
 */
public class DealAnnotation {
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		Class clazz;
		try {
			clazz = Class.forName("java300.Student");
			//��������е�ע��
			Annotation[] annotations= clazz.getAnnotations();
			for(Annotation temp: annotations) {
				System.out.println(temp);
			}
			//�����ָ����ע��
			StudentTable st = (StudentTable) clazz.getAnnotation(StudentTable.class);
			System.out.println(st.value());
			//��������Ե�ע��
			Field f = clazz.getDeclaredField("studentName");
			StudentFiled sdtb = f.getAnnotation(StudentFiled.class);
			System.out.println(sdtb);
			
			//���ݻ�ȡ���ֶ�,���ɱ����Ϣ
			
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
