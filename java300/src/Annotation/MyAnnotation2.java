package Annotation;
/**
 * ͨ���������ע��
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//ָ��ע���ʹ�÷�Χ
@Target(value= ElementType.METHOD)
//��ʾʲô����ı����ע����Ϣ SOURCE  CLASS  RUNTIME
@Retention (RetentionPolicy.RUNTIME)

public @interface MyAnnotation2 {
	//ֻ��һ��ֵ�Ļ�,һ�㶨��Ϊvalue
	String value();
}
