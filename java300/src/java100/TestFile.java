package java100;

import java.io.File;
import java.io.IOException;

public class TestFile {
	public static void main(String[] args) {
		File f = new File("E:/1.txt");
		File f2= new File("d:/git");
		/**
		 * 检查文件是什么类型
		 */
		if(f.isFile())
		{
			System.out.println("是一个文件");
		}
		if(f2.isDirectory())
		{
			System.out.println("是一个目录");
		}
		System.out.println(f2.lastModified());
		System.out.println(f2.getName());
		
		System.out.println("######################");
		/**
		 * 创建一个文件
		 */
		File f3=new File("E:/1.java");
		try {
			f3.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * 删除一个文件
		 */
		f3.delete();
		f.delete();
		/**
		 * mkdris 和 mkdir一个创建一个目录,一个迭代创建多个目录
		 */
		File f4 = new File("E:/ass/saf/fasf/asfa");
		f4.mkdirs();
	}
}
