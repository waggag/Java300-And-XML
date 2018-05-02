package cn.waggag.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * ����Ŀ¼
 * mkdir() ���뱣֤��Ŀ¼����
 * mkdirs() ��Ŀ¼������,һ�𴴽�
 * @author waggag
 * 2018��4��15������11:18:01
 */
public class OperDirectoy {
	
	public static void DirMethod() {
		String path = "G:";
		File src = new File(path);
		//src.mkdir();
		
		System.out.println("=====��Ŀ¼|���ļ���=====");
		String[] subNames = src.list();
		for(String temp: subNames) {
			System.out.println(temp);
		}
		
		System.out.println("=====��Ŀ¼|File����=====");
		File[] subFiles = src.listFiles();
		for(File temp : subFiles) {
			System.out.println(temp.getAbsolutePath());
		}
		
		System.out.println("=====��Ŀ¼|java����=====");
		//�������ģʽ
		subFiles = src.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File src, String name) {
				return new File(src,name).isFile() && name.endsWith(".java");
			}
		});
		
		for(File temp: subFiles)
		{
			System.out.println(temp.getAbsolutePath());
		}
	}
	
	/**
	 * ������ＶĿ¼���ļ������ƣ�����·��
	 * 1.listFiles()
	 * 2.�ݹ�
	 */
	public static void printDirectory() {
		String path = "G:/test";
		File parent = new File(path);
		printNames(parent);
		
	}
	
	public static void printDirectory(String _path) {
		String path = _path;
		File parent = new File(path);
		printNames(parent);
		
	}
	
	/**
	 * ���·��������
	 */
	public static void printNames(File src) {
		if(src == null || !src.exists()) {
			return ;
		}
		System.out.println(src.getAbsolutePath());
		if(src.isDirectory())//�ļ���
		{	
			/**
			 * ��һ������������������׺ΪJava���ļ�
			 */
//			for(File temp: src.listFiles(new FilenameFilter() {
//				
//				@Override
//				public boolean accept(File src, String name) {
//					return new File(src,name).isFile() && name.endsWith(".java");
//				}
//			}))
			
			for(File temp: src.listFiles())
			{
				printNames(temp);
			}
		}
	}
	public static void main(String[] args) {
		//����ƶ��̷�������
		printDirectory();
		//������еĸ�Ŀ¼
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
		
		
	}
	
}
