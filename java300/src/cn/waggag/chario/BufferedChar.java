package cn.waggag.chario;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 字节流文件拷贝+ 缓冲流，提高性能
 * 缓冲流(节点流)
 * @author waggag
 * 2018年4月15日下午8:02:40
 */
public class BufferedChar {
	/**
	 * 文件的拷贝
	 * @param srcPath   源文件的路径
	 * @param destPath 目标文件的路径
	 * @throws IOException  抛出的异常
	 */
	public static void copyFile(String srcPath, String destPath) 
				throws FileNotFoundException,IOException
	{
		//1.建立联系 源（存在且为文件） + 目的地
		File src = new File(srcPath);
		File dest = new File(destPath);
		if(!src.isFile()) {
			System.out.println("只能拷贝文件");
			try {
				throw new Exception("只能拷贝文件");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//2.选择流
		InputStream is = new BufferedInputStream ( new FileInputStream(src));
		OutputStream os = new BufferedOutputStream ( new FileOutputStream(dest)) ;
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
