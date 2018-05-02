package cn.waggag.file;

import java.io.File;
import java.io.IOException;

/**
 * �����ļ����ļ���
 * 1.�ļ����� copyFile
 * 2.�ļ��еĴ��� mkdirs()
 * 3.�ݹ�������Ｖ
 * 
 * ���ܣ��ܹ���һ���ļ����µ�Ŀ¼���ļ���������һ��Ŀ¼��
 * 
 * @author waggag
 * 2018��4��15������4:28:44
 */
public class CopyFileAndDirectory {
	
	public static void main(String[] args) {
		/**
		 * Ŀ�����ͬ���ļ�ʱ��ֱ�Ӹ��ǣ�ͬ���ļ���ʱ�׳��쳣
		 */
		//Դ�ļ�Ŀ¼
		String srcPath = "G:/1/2.txt";
		//Ŀ���ļ�
		String destPath = "G:/2.txt";
		
		copyDirectory(srcPath, destPath);	
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
	 * @param src ԴFile����
	 * @param dest Ŀ��File����
	 */
	public static void copyDirectory(File src, File dest) {
		
		if(src.isDirectory()) { //�ļ���
			dest = new File(dest, src.getName());
		}
		copy(src, dest);		
	}
	
	/**
	 * �����ļ���
	 */
	public static void copy(File src, File dest) {
		if(src.isFile()) {
			try {
				/**
				 * copyFileֻ�ܶ�2���ļ����п������޷���һ���ļ�������һ��Ŀ¼��
				 */
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

}
