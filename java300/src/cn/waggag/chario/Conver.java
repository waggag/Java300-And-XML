package cn.waggag.chario;

import java.io.UnsupportedEncodingException;

/**
 * ���������
 * @author waggag
 * 2018��4��15������8:19:03
 */
public class Conver {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String str = "�й�";
		byte[] data = str.getBytes();
		//�ֽ����������������
		System.out.println(new String(data, 0, 3));
	}
	/**
	 * ����������ַ���������ͬ����������
	 * @throws UnsupportedEncodingException 
	 */
	public static void test() throws UnsupportedEncodingException {
		
		//���� byte --> char
		String str = "����";  //gbk
		//���� char --> byte
		byte[] data = str.getBytes();	
		//�����������ַ�ͬ��
		System.out.println(str);
		try {
			data = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} //�趨�����ַ���
		//��ͳһ��������
		System.out.println(data);
		System.out.println("==============");
		
		//���� byte --> char
		byte[] data2 = "����".getBytes("utf-8");  //gbk
		//���� char --> byte
		str = new String(data2, "utf-8");
		System.out.println(str);
		
		
	}
	
	
}
