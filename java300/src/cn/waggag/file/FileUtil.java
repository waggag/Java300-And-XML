package cn.waggag.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * File�Ĺ��߰�
 * @author waggag
 * 2018��4��15������4:21:38
 */
public class FileUtil {
	
	/**
	 * ������ر���
	 * �ɱ����: ... ֻ�ܷ������һ��λ��
	 * ����ʽ������һ��
	 */
	public static void close(Closeable ...io) {
		for(Closeable  temp: io)
		{
			if(temp != null) {
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * �ļ��еĿ���
	 * @param srcPath  Դ�ļ���·��
	 * @param destPath  Ŀ���ļ���·��
	 */
	public static void copyDirectory(String srcPath, String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);
		if(src.isDirectory()) { //�ļ���
			dest = new File(destPath, src.getName());
		}
		copyDirectory(src, dest);	
	}
	
	/**
	 * �����ļ���
	 * @param src Դ�ļ���File����
	 * @param dest Ŀ���ļ���File����
	 */
	public static void copyDirectory(File src, File dest) {
		
		if(src.isDirectory()) { //�ļ���
			dest = new File(dest, src.getName());
		}
		if(dest.getAbsolutePath().contains(src.getAbsolutePath()))
		{
			System.out.println("��Ŀ¼���ܿ�������Ŀ¼��");
			return ;
		}
		copy(src, dest);		
	}
	
	/**
	 * �����ļ��У���һ���ļ���������һ���ļ�����
	 */
	public static void copy(File src, File dest) {
		if(src.isFile()) {
			try {
				FileUtil.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else  if(src.isDirectory()){  //�ļ���
			//ȷ��Ŀ���ļ��д���
			dest.mkdirs();
			//��ȡ��һ��Ŀ¼
			for(File sub: src.listFiles())
			{
				copyDirectory(sub, new File(dest, sub.getName()));
			}
		}
		
	}
	
	/**
	 * �����ļ��Ŀ���
	 * @param srcPath  Դ�ļ���·��
	 * @param destPath  Ŀ���ļ���·��
	 * @throws IOException  �׳����쳣
	 */
	public static void copyFile(String srcPath, String destPath) throws IOException
	{
		//1.������ϵ Դ��������Ϊ�ļ��� + Ŀ�ĵ�
		copyFile(new File(srcPath), new File(destPath));	
	}
	/**
	 * @param src  Դ�ļ���File����
	 * @param dest 	Ŀ���ļ���File����
	 * @throws IOException
	 */
	public static void copyFile(File src, File dest) throws FileNotFoundException,IOException
	{
		/**
		 * �������һ���ļ����׳�һ���쳣
		 */
		if(!src.isFile()) {
			try {
				throw new Exception("ֻ�ܿ����ļ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * ���destΪһ���Ѿ����ڵ��ļ��У����ܽ����ļ���ͬ���ļ�
		 */
		if(dest.isDirectory()) {
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException(dest.getAbsolutePath()+" ���ܽ����ļ���ͬ���ļ�");
		}
		
		//ѡ����
		InputStream is = new BufferedInputStream (new FileInputStream(src));
		OutputStream os = new BufferedOutputStream (new FileOutputStream(dest));
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
