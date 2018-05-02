package cn.waggag.file;

import java.io.File;

/**
 * 2个常用常量
 * 1.路径分隔符 ;
 * 2.文件分割符
 * windows \     linux  /
 * @author waggag
 * 2018年4月15日上午10:46:44
 */
public class TestFile {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//路径表示
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		String path = "D:/Git/1.bmp";
		//动态生成时使用
		path = "D:"+File.separator+"Git"+File.separator+"1.bmp";
		//推荐使用
		path = "D:/Git/1.bmp";
		
		
		/**
		 * 相对路径与绝对路径
		 */
		String parentPath = "E:/xp/test";
		String name = "2.jpg";
		//相对路径
		System.out.println("======相对路径=====");
		File src = new File(parentPath,name);
		src = new File(new File(parentPath), name);
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//绝对路径
		System.out.println("======绝对路径=====");
		src = new File("E:/xp/test/2.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//没有盘符，以user.dir构建
		src = new File("test.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
		
		
	}
}
