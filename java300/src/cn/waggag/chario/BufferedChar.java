package cn.waggag.chario;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * �ֽ����ļ�����+ ���������������
 * ������(�ڵ���)
 * @author waggag
 * 2018��4��15������8:02:40
 */
public class BufferedChar {
	/**
	 * �ļ��Ŀ���
	 * @param srcPath   Դ�ļ���·��
	 * @param destPath Ŀ���ļ���·��
	 * @throws IOException  �׳����쳣
	 */
	public static void copyFile(String srcPath, String destPath) 
				throws FileNotFoundException,IOException
	{
		//1.������ϵ Դ��������Ϊ�ļ��� + Ŀ�ĵ�
		File src = new File(srcPath);
		File dest = new File(destPath);
		if(!src.isFile()) {
			System.out.println("ֻ�ܿ����ļ�");
			try {
				throw new Exception("ֻ�ܿ����ļ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//2.ѡ����
		InputStream is = new BufferedInputStream ( new FileInputStream(src));
		OutputStream os = new BufferedOutputStream ( new FileOutputStream(dest)) ;
		//3.�ļ�������ѭ�� + ��ȡ + д��
		byte[] flush = new byte[1024];
		int len = 0;
		while((len = is.read(flush)) != -1)
		{
			//д��
			os.write(flush, 0, len);
		}
		os.flush(); 	//ǿ��ˢ��
		//�ر���
		os.close();
		is.close();	
		
	}
	
}
