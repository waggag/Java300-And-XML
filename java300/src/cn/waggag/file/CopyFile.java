package cn.waggag.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 拷贝文件
 * @author waggag
 * 2018年4月15日下午4:01:06
 */
public class CopyFile {
	
	public static void main(String[] args) throws IOException {
		String src = "E:/1.txt";
		String dest = "E:/2.txt";
		copyFile(src, dest);
	}
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
			try {
				throw new Exception("只能拷贝文件");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//选择流
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
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
		FileUtil.close(os, is);
	}
}
