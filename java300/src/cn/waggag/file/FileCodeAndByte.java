package cn.waggag.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1.文件 --> 程序 --> 字节数组
 * 	文件输入流
 * 	字节数组输出流
 * 2.字节数组 --> 程序 -->文件
 * 	字节数组输出流
 * 	文件输出流
 * @author waggag
 * 2018年4月16日 下午8:08:20
 */
public class FileCodeAndByte {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		byte[] data = getBytesFromFiles("F:/1.txt");
		toFileFromByteArray(data, "F:/3.txt");
		System.out.println(new String(data));
			
	}
	/**
	 * 2.字节数组 --> 程序 -->文件
	 * 	字节数组输入流
	 * 	文件输出流
	 * @throws IOException
	 */
	public static void toFileFromByteArray(byte[] src, String destPath) throws IOException
	{
		//创建源
		//目的地
		File dest = new File(destPath);
		//字节数组输入流
		InputStream is =new BufferedInputStream(new ByteArrayInputStream(src));
		//文件输出流
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		//操作,不断将读取文件写出到字节数组流中
		byte[] flush = new byte[1024];
		int len = 0;
		while((len = is.read(flush)) != -1)
		{
			//写入到字节数组中
			os.write(flush, 0, len);			
		}
		os.flush();
		//释放资源
		os.close();
		is.close();
	}
	
	
	/**
	 * 1.文件 --> 程序 --> 字节数组
	 * 	文件输入流
	 * 	字节数组输出流
	 */
	public static byte[] getBytesFromFiles (String srcPath) 
			throws FileNotFoundException,IOException
	{
		//创建文件源
		File src = new File(srcPath);
		//创建字节数组目的地
		byte[] dest = null;
		//选择流
		//文件输入流
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		//字节数组输出流,不能使用多态
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		//操作,不断将读取文件写出到字节数组流中
		byte[] flush = new byte[1024];
		int len = 0;
		while((len = is.read(flush)) != -1)
		{
			//写入到字节数组中
			bos.write(flush, 0, len);			
		}
		bos.flush();
		//获取数据
		dest = bos.toByteArray();
		bos.close();
		is.close();
		return dest;	
	}
	
	
	
	
	
	
	
}
