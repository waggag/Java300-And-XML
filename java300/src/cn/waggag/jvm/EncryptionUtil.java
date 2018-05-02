package cn.waggag.jvm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ���ܹ�����
 * @author waggag
 * 2018��4��28�� ����4:22:59
 */
public class EncryptionUtil {
	
	public static void main(String[] args) {
		encrpt("e:/myjava/Hello.class", "e:/myjava/temp/Hello.class");
	}
	
	public static void encrpt(String src, String dest) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			
			//����class�ļ��ļ��ܴ��������ļ���ȡ������
			int temp = -1;
			while((temp = fis.read()) != -1) {
				fos.write(temp^0xff);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
