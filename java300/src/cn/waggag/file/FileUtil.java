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
 * File的工具包
 * @author waggag
 * 2018年4月15日下午4:21:38
 */
public class FileUtil {
	
	/**
	 * 工具类关闭流
	 * 可变参数: ... 只能放在最后一个位置
	 * 处理方式与数组一致
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
	 * @param src 源文件夹File对象
	 * @param dest 目标文件夹File对象
	 */
	public static void copyDirectory(File src, File dest) {
		
		if(src.isDirectory()) { //文件夹
			dest = new File(dest, src.getName());
		}
		if(dest.getAbsolutePath().contains(src.getAbsolutePath()))
		{
			System.out.println("父目录不能拷贝到子目录中");
			return ;
		}
		copy(src, dest);		
	}
	
	/**
	 * 拷贝文件夹，把一个文件拷贝到另一个文件夹下
	 */
	public static void copy(File src, File dest) {
		if(src.isFile()) {
			try {
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
	
	/**
	 * 对于文件的拷贝
	 * @param srcPath  源文件的路径
	 * @param destPath  目标文件的路径
	 * @throws IOException  抛出的异常
	 */
	public static void copyFile(String srcPath, String destPath) throws IOException
	{
		//1.建立联系 源（存在且为文件） + 目的地
		copyFile(new File(srcPath), new File(destPath));	
	}
	/**
	 * @param src  源文件的File对象
	 * @param dest 	目标文件的File对象
	 * @throws IOException
	 */
	public static void copyFile(File src, File dest) throws FileNotFoundException,IOException
	{
		/**
		 * 如果不是一个文件，抛出一个异常
		 */
		if(!src.isFile()) {
			try {
				throw new Exception("只能拷贝文件");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 如果dest为一个已经存在的文件夹，不能建立文件夹同名文件
		 */
		if(dest.isDirectory()) {
			System.out.println("只能拷贝文件");
			throw new IOException(dest.getAbsolutePath()+" 不能建立文件夹同名文件");
		}
		
		//选择流
		InputStream is = new BufferedInputStream (new FileInputStream(src));
		OutputStream os = new BufferedOutputStream (new FileOutputStream(dest));
		//3.文件拷贝，循环 + 读取 + 写入
		byte[] flush = new byte[1024];
		int len = 0;
		while((len = is.read(flush)) != -1)
		{
			//写出
			os.write(flush, 0, len);
		}
		os.flush(); 	//强制刷出
		//关闭流
		os.close();
		is.close();		
	}	
}
