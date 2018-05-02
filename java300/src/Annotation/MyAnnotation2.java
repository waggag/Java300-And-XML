package Annotation;
/**
 * 通过程序解析注解
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//指定注解的使用范围
@Target(value= ElementType.METHOD)
//表示什么级别的保存该注释信息 SOURCE  CLASS  RUNTIME
@Retention (RetentionPolicy.RUNTIME)

public @interface MyAnnotation2 {
	//只有一个值的话,一般定义为value
	String value();
}
