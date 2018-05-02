package cn.waggag.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * �����ļ�
 * @author waggag
 * 2018��4��15������4:01:06
 */
public class CopyFile {
	
	public static void main(String[] args) throws IOException {
		String src = "E:/1.txt";
		String dest = "E:/2.txt";
		copyFile(src, dest);
	}
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
			try {
				throw new Exception("ֻ�ܿ����ļ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//ѡ����
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
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
		FileUtil.close(os, is);
	}
}
