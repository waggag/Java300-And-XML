package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//ָ��ע���ʹ�÷�Χ
@Target(value= ElementType.TYPE)
//��ʾʲô����ı����ע����Ϣ SOURCE  CLASS  RUNTIME
@Retention (RetentionPolicy.RUNTIME)
public @interface StudentTable {

	String value();
}

