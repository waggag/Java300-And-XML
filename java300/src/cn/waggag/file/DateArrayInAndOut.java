package cn.waggag.file;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * �ļ����ݲ���̫��
 * 1.�ļ� --> ���� --> �ֽ�����
 * 2.�ֽ����� --> ���� -->�ļ�
 * �ֽ�����Ľڵ���
 * @author waggag
 * 2018��4��16�� ����7:25:09
 */
public class DateArrayInAndOut {
	
	public static void main(String[] args) {
		try {
			read(write());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �����,�������ļ��������Щ��ͬ,����������,����ʹ�ö�̬
	 * ���ֽ�����д���ַ���ת��������
	 * @return 
	 */
	public static byte[] write() {
		//Ŀ�ĵ�
		byte[] dest;
		//ѡ����   ��ͬ��
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//д��
		String meg = "����   is very good!";
		byte[] info = meg.getBytes();
		bos.write(info, 0, info.length);
		//��ȡ����
		dest = bos.toByteArray();
		try {
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	/**
	 * ������,�������ļ�������һ��
	 * ��ȡ�ֽ�����
	 * @throws IOException 
	 */
	 public static void read(byte[] src) throws IOException {
		 //����Դ����
		 //ѡ����
		 InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		 //����
		 byte[] flush = new byte[1024];
		 int len = 0;
		 while((len = is.read(flush)) != -1)
		 {
			 System.out.println(new String(flush, 0, len));
		 }
		 //�ͷ���Դ
		 is.close(); 
	 }
}
