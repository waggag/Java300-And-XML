package cn.waggag.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * 操作目录
 * mkdir() 必须保证父目录存在
 * mkdirs() 父目录不存在,一起创建
 * @author waggag
 * 2018年4月15日上午11:18:01
 */
public class OperDirectoy {
	
	public static void DirMethod() {
		String path = "G:";
		File src = new File(path);
		//src.mkdir();
		
		System.out.println("=====子目录|子文件名=====");
		String[] subNames = src.list();
		for(String temp: subNames) {
			System.out.println(temp);
		}
		
		System.out.println("=====子目录|File对象=====");
		File[] subFiles = src.listFiles();
		for(File temp : subFiles) {
			System.out.println(temp.getAbsolutePath());
		}
		
		System.out.println("=====子目录|java对象=====");
		//命令设计模式
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
	 * 输出子孙级目录，文件的名称，绝对路径
	 * 1.listFiles()
	 * 2.递归
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
	 * 输出路径的名称
	 */
	public static void printNames(File src) {
		if(src == null || !src.exists()) {
			return ;
		}
		System.out.println(src.getAbsolutePath());
		if(src.isDirectory())//文件夹
		{	
			/**
			 * 加一个过滤器，至搜索后缀为Java的文件
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
		//输出制定盘符的内容
		printDirectory();
		//输出所有的根目录
		File[] roots = File.listRoots();
		System.out.println(Arrays.toString(roots));
		
		
	}
	
}
