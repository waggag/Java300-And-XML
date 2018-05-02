package cn.waggag.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1.�ļ� --> ���� --> �ֽ�����
 * 	�ļ�������
 * 	�ֽ����������
 * 2.�ֽ����� --> ���� -->�ļ�
 * 	�ֽ����������
 * 	�ļ������
 * @author waggag
 * 2018��4��16�� ����8:08:20
 */
public class FileCodeAndByte {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		byte[] data = getBytesFromFiles("F:/1.txt");
		toFileFromByteArray(data, "F:/3.txt");
		System.out.println(new String(data));
			
	}
	/**
	 * 2.�ֽ����� --> ���� -->�ļ�
	 * 	�ֽ�����������
	 * 	�ļ������
	 * @throws IOException
	 */
	public static void toFileFromByteArray(byte[] src, String destPath) throws IOException
	{
		//����Դ
		//Ŀ�ĵ�
		File dest = new File(destPath);
		//�ֽ�����������
		InputStream is =new BufferedInputStream(new ByteArrayInputStream(src));
		//�ļ������
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		//����,���Ͻ���ȡ�ļ�д�����ֽ���������
		byte[] flush = new byte[1024];
		int len = 0;
		while((len = is.read(flush)) != -1)
		{
			//д�뵽�ֽ�������
			os.write(flush, 0, len);			
		}
		os.flush();
		//�ͷ���Դ
		os.close();
		is.close();
	}
	
	
	/**
	 * 1.�ļ� --> ���� --> �ֽ�����
	 * 	�ļ�������
	 * 	�ֽ����������
	 */
	public static byte[] getBytesFromFiles (String srcPath) 
			throws FileNotFoundException,IOException
	{
		//�����ļ�Դ
		File src = new File(srcPath);
		//�����ֽ�����Ŀ�ĵ�
		byte[] dest = null;
		//ѡ����
		//�ļ�������
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		//�ֽ����������,����ʹ�ö�̬
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		//����,���Ͻ���ȡ�ļ�д�����ֽ���������
		byte[] flush = new byte[1024];
		int len = 0;
		while((len = is.read(flush)) != -1)
		{
			//д�뵽�ֽ�������
			bos.write(flush, 0, len);			
		}
		bos.flush();
		//��ȡ����
		dest = bos.toByteArray();
		bos.close();
		is.close();
		return dest;	
	}
	
	
	
	
	
	
	
}
