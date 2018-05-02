package java300;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式在java中的用法
 * @author waggag
 * 2018年4月29日 上午8:49:16
 */
public class Test {
	
	public static void main(String[] args) {
		//在这个字符串中： sadhksa45648,是否存在指定的正则表达式： \w+
		//表达式对象
		Pattern p = Pattern.compile("\\w+");
		
		//创建Match对象
		Matcher m = p.matcher("sdagk&&sf545s4s");
		
		while(m.find()) {
			//group和group(0)匹配整个字符串
			System.out.println(m.group(0));
		}
		
	}
}
