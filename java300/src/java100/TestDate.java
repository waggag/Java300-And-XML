package java100;

import java.util.Date;
/**
 * ����Date���ʹ��
 * @author ����
 */
public class TestDate 
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) 
	{
		Date d = new Date();
		System.out.println(d.toLocaleString());
		Date d2 = new Date(1000);
		System.out.println(d2.toLocaleString());
		
	}
	
}
