package cn.waggag.guava;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * 函数式编程
 * 1. Predicate 
 * 2. Functions
 * 工具：Collections2.filter() 过滤器
 * @author waggag
 * 2018年4月14日下午4:11:08
 */
public class FunctionalProUsingGuava {
	public static  void palindrome() {
		//创建List 静态初始化
		List<String> list = Lists.newArrayList("moom", "son", "dad","waggag");
		//找出回文 palindrome
		//匿名内部类只是用一次可以用匿名内部类
		Collection<String> palindromeList = Collections2.filter(list, new Predicate<String>() {

				@Override
				public boolean apply(String arg0) {
					//业务逻辑
					return new StringBuilder(arg0).reverse().toString().equals(arg0);
				}
		});
		
		for(String temp: palindromeList) {
			System.out.println(temp);
		}
				
	}
	/**
	 * Collections.transfer转换
	 */
	public static void TimeFormat() {
		//类型转换
		Set<Long> timeSet = Sets.newHashSet();
		timeSet.add(10000000L);
		timeSet.add(9999999999999L);
		timeSet.add(20000000000L);
		
		Collection<String> timeStr = Collections2.transform(timeSet, new Function<Long, String>(){

			@Override
			public String apply(Long arg0) {
				return new SimpleDateFormat("yyyy-MM--dd").format(arg0);
			}
			
			
		});
		for(String temp: timeStr){
			System.out.println(temp);
		}
	}
	/**
	 * 使用Collectios.compse进行组合式函数编程
	 */
	public static void CombinedFunctionProGrammer(){
		//组合式函数编程，确保容器中的字符串长都不超过5,超过后截取，后全部大写
		List<String> list = Lists.newArrayList("waggag","goods","happiness");
		//确保容器中的字符串长都不超过5
		Function<String , String> f1 = new Function<String, String>(){

			@Override
			public String apply(String arg0) {
				return arg0.length()>5 ? arg0.substring(0,5) : arg0;
			}
			
		};
		Function<String , String> f2 = new Function<String, String>(){

			@Override
			public String apply(String arg0) {
				return arg0.toUpperCase();
			}
			
		};
		//使用compse进行组合式函数编程
		Function<String, String> f = Functions.compose(f1, f2);
		Collection<String> result = Collections2.transform(list, f);
		
		for(String temp: result)
		{
			System.out.println(temp);
		}
	}
	
	public static void main(String[] args) {
		CombinedFunctionProGrammer();
 	}
		
}
