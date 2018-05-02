package cn.waggag.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �������ʹ�����
 * 1.������: DataInputStream
 * 2.�����: DataOutputStream
 * 	�����������ܼ����̬
 * @author waggag
 * 2018��4��16�� ����8:42:56
 */
public class DealStream {
	
	public static void main(String[] args) throws IOException 
	{
		write("F:/1.txt");
		read("F:/1.txt");
	}
	/**
	 * ���ļ��ж�ȡ���� �� String
	 * @throws IOException 
	 */


	@SuppressWarnings("resource")
	public static void read(String srcPath) throws IOException {
		//����Դ
		File src = new File(srcPath);
		//ѡ����
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
						)
				);
		//����,ע���ȡ��������д��һ��,������ڲ��ܶ�ȡ
		double num1 = dis.readDouble();
		long long2 = dis.readLong();
		String str1 = dis.readUTF();
		System.out.println(str1);
		System.out.println(long2);
		System.out.println(num1);
		
	}
	
	/**
	 * ���ݼ�����������ļ�
	 * @throws IOException 
	 */
	public static void write(String destPath) throws IOException
	{
		double point = 2.5;
		long num = 100L;
		String str = "��������";
		//����Դ
		File dest = new File(destPath);
		//ѡ����
		DataOutputStream dos = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(dest)) 
				);
		//����
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		
		dos.flush();
		dos.close();
		
	}
	
	
}


