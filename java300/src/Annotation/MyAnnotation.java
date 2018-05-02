package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解,需要加上2个源注解
 * @author waggag
 * 2018年4月23日 下午7:41:32
 */
//指定注解的使用范围
@Target(value= ElementType.METHOD)
//表示什么级别的保存该注释信息 SOURCE  CLASS  RUNTIME
@Retention (RetentionPolicy.RUNTIME)

public @interface MyAnnotation {
	
	String studentName() default "";
	int age() default 0;
	//表示不存在的意思
	int id() default -1;
	String[] schools() default {"清华大学","郑工"};
}
