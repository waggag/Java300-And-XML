package cn.waggag.chario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ת���� �ֽ�תΪ�ַ�
 * 1.�����   OutputStreamWriter ����
 * 2.������	InputerStreamReader ����
 * @author waggag
 * 2018��4��15������8:33:31
 */
public class SwitchStream {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//ָ�������ַ���
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(new File("G:/2.txt")),"utf-8")
				);
		//д���ļ�
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("G:/1.txt",true)
				);
		String info = null;
		while((info = br.readLine()) != null)
		{
			System.out.println(info);
			bw.write(info);
			bw.newLine();
		}
		bw.flush();
		br.close();
	}
}
