package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * �Զ���ע��,��Ҫ����2��Դע��
 * @author waggag
 * 2018��4��23�� ����7:41:32
 */
//ָ��ע���ʹ�÷�Χ
@Target(value= ElementType.METHOD)
//��ʾʲô����ı����ע����Ϣ SOURCE  CLASS  RUNTIME
@Retention (RetentionPolicy.RUNTIME)

public @interface MyAnnotation {
	
	String studentName() default "";
	int age() default 0;
	//��ʾ�����ڵ���˼
	int id() default -1;
	String[] schools() default {"�廪��ѧ","֣��"};
}
