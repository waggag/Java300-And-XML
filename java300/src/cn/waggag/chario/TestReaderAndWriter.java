package cn.waggag.chario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * ���ı���ȡ��д��
 * @author waggag
 * 2018��4��15������7:10:50
 */
public class TestReaderAndWriter {
	
	public static void main(String[] args) {
		copyPlainText();
	}
	
	public static void copyPlainText() {
		//����Դ
		File src = new File("G:/2.txt");
		File dest = new File("G:/1.txt");
		//ѡ����
		Writer wr = null;
		Reader reader = null;
		
		try {
			reader =  new FileReader(src);
			wr = new FileWriter(dest, true);
			//��ȡ����
			char[] flush = new char[10];
			int len = 0;
			//ѭ���������е�����
			while((len = reader.read(flush)) != -1)
			{
				wr.write(flush, 0, len);
			}
			wr.flush(); //ǿ��ˢ��
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("Դ�ļ�������");
		} catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("�ļ���ȡʧ��");
		} finally 
		{
			if(wr != null) {
				try {
					wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
		
	}
		
	/**
	 * ���ı���д��
	 */
	public static void writerText() {
		
		//����Դ
		File dest = new File("G:/2.txt");
		//ѡ����
		Writer wr = null;
		try {
			wr = new FileWriter(dest,true);//׷���ļ��������Ǹ����ļ���Ĭ��Ϊ�����ļ�
			//д��
			String msg = "waggag is very good!\r\n";
			wr.write(msg);
			wr.append("he is very goods!\r\n");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(wr != null)
			{
				try {
					wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * ���ı��Ķ�ȡ
	 */
	@SuppressWarnings("unused")
	public static void readText() {
		//����Դ
		File src = new File("G:/1.txt");
		//ѡ����
		Reader reader = null;
		try {
			reader =  new FileReader(src);
			//��ȡ����
			char[] flush = new char[10];
			int len = 0;
			while((len = reader.read(flush)) != -1)
			{
				//�ַ�����תΪ�ַ���
				String str = new String(flush);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Դ�ļ�������");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ���ȡʧ��");
		} finally {
			if(reader != null)
			{
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	
	}
}
