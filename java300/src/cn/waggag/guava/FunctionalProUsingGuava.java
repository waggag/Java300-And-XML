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
 * ����ʽ���
 * 1. Predicate 
 * 2. Functions
 * ���ߣ�Collections2.filter() ������
 * @author waggag
 * 2018��4��14������4:11:08
 */
public class FunctionalProUsingGuava {
	public static  void palindrome() {
		//����List ��̬��ʼ��
		List<String> list = Lists.newArrayList("moom", "son", "dad","waggag");
		//�ҳ����� palindrome
		//�����ڲ���ֻ����һ�ο����������ڲ���
		Collection<String> palindromeList = Collections2.filter(list, new Predicate<String>() {

				@Override
				public boolean apply(String arg0) {
					//ҵ���߼�
					return new StringBuilder(arg0).reverse().toString().equals(arg0);
				}
		});
		
		for(String temp: palindromeList) {
			System.out.println(temp);
		}
				
	}
	/**
	 * Collections.transferת��
	 */
	public static void TimeFormat() {
		//����ת��
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
	 * ʹ��Collectios.compse�������ʽ�������
	 */
	public static void CombinedFunctionProGrammer(){
		//���ʽ������̣�ȷ�������е��ַ�������������5,�������ȡ����ȫ����д
		List<String> list = Lists.newArrayList("waggag","goods","happiness");
		//ȷ�������е��ַ�������������5
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
		//ʹ��compse�������ʽ�������
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
