package java300;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����������ʽ��java�е��÷�
 * @author waggag
 * 2018��4��29�� ����8:49:16
 */
public class Test {
	
	public static void main(String[] args) {
		//������ַ����У� sadhksa45648,�Ƿ����ָ����������ʽ�� \w+
		//���ʽ����
		Pattern p = Pattern.compile("\\w+");
		
		//����Match����
		Matcher m = p.matcher("sdagk&&sf545s4s");
		
		while(m.find()) {
			//group��group(0)ƥ�������ַ���
			System.out.println(m.group(0));
		}
		
	}
}
