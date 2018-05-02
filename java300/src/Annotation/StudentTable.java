package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//指定注解的使用范围
@Target(value= ElementType.TYPE)
//表示什么级别的保存该注释信息 SOURCE  CLASS  RUNTIME
@Retention (RetentionPolicy.RUNTIME)
public @interface StudentTable {

	String value();
}

