package Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解的信息,模拟处理注解信息的流程
 * @author waggag
 * 2018年4月23日 下午8:16:08
 */
public class DealAnnotation {
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		Class clazz;
		try {
			clazz = Class.forName("java300.Student");
			//获得类所有的注解
			Annotation[] annotations= clazz.getAnnotations();
			for(Annotation temp: annotations) {
				System.out.println(temp);
			}
			//获得类指定的注解
			StudentTable st = (StudentTable) clazz.getAnnotation(StudentTable.class);
			System.out.println(st.value());
			//获得类属性的注解
			Field f = clazz.getDeclaredField("studentName");
			StudentFiled sdtb = f.getAnnotation(StudentFiled.class);
			System.out.println(sdtb);
			
			//根据获取的字段,生成表的信息
			
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
