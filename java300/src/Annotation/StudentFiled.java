package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target (value= {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StudentFiled {
	String columName();
	String type();
	int length();
}