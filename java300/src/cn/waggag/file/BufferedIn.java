package cn.waggag.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ��װ����
 * @author waggag
 * 2018��4��17������8:39:26
 */
public class BufferedIn {
	
	public static void main(String[] args) throws IOException {
		InputStream is =System.in;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println("�����룺");
		String msg = br.readLine();
		System.out.println(msg);
	}
}
