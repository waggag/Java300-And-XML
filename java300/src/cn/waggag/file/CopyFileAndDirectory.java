package cn.waggag.file;

import java.io.File;
import java.io.IOException;

/**
 * 拷贝文件和文件夹
 * 1.文件复制 copyFile
 * 2.文件夹的创建 mkdirs()
 * 3.递归查找子孙级
 * 
 * 功能：能够把一个文件夹下的目录和文件拷贝到另一个目录下
 * 
 * @author waggag
 * 2018年4月15日下午4:28:44
 */
public class CopyFileAndDirectory {
	
	public static void main(String[] args) {
		/**
		 * 目标存在同名文件时，直接覆盖，同名文件夹时抛出异常
		 */
		//源文件目录
		String srcPath = "G:/1/2.txt";
		//目标文件
		String destPath = "G:/2.txt";
		
		copyDirectory(srcPath, destPath);	
	}
	
	/**
	 * 文件夹的拷贝
	 * @param srcPath  源文件的路径
	 * @param destPath  目标文件的路径
	 */
	public static void copyDirectory(String srcPath, String destPath) {
		File src = new File(srcPath);
		File dest = new File(destPath);
		if(src.isDirectory()) { //文件夹
			dest = new File(destPath, src.getName());
		}
		copyDirectory(src, dest);	
	}
	
	/**
	 * 拷贝文件夹
	 * @param src 源File对象
	 * @param dest 目标File对象
	 */
	public static void copyDirectory(File src, File dest) {
		
		if(src.isDirectory()) { //文件夹
			dest = new File(dest, src.getName());
		}
		copy(src, dest);		
	}
	
	/**
	 * 拷贝文件夹
	 */
	public static void copy(File src, File dest) {
		if(src.isFile()) {
			try {
				/**
				 * copyFile只能对2个文件进行拷贝，无法把一个文件拷贝到一个目录下
				 */
				FileUtil.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else  if(src.isDirectory()){  //文件夹
			//确保目标文件夹存在
			dest.mkdirs();
			//获取下一级目录
			for(File sub: src.listFiles())
			{
				copyDirectory(sub, new File(dest, sub.getName()));
			}
		}
		
	}

}
