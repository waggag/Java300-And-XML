package cn.waggag.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据类型处理流
 * 1.输入流: DataInputStream
 * 2.输出流: DataOutputStream
 * 	新增方法不能加入多态
 * @author waggag
 * 2018年4月16日 下午8:42:56
 */
public class DealStream {
	
	public static void main(String[] args) throws IOException 
	{
		write("F:/1.txt");
		read("F:/1.txt");
	}
	/**
	 * 从文件中读取数据 和 String
	 * @throws IOException 
	 */


	@SuppressWarnings("resource")
	public static void read(String srcPath) throws IOException {
		//创建源
		File src = new File(srcPath);
		//选择流
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
						)
				);
		//操作,注意读取的数据与写出一致,必须存在才能读取
		double num1 = dis.readDouble();
		long long2 = dis.readLong();
		String str1 = dis.readUTF();
		System.out.println(str1);
		System.out.println(long2);
		System.out.println(num1);
		
	}
	
	/**
	 * 数据加类型输出到文件
	 * @throws IOException 
	 */
	public static void write(String destPath) throws IOException
	{
		double point = 2.5;
		long num = 100L;
		String str = "数据类型";
		//创建源
		File dest = new File(destPath);
		//选择流
		DataOutputStream dos = new DataOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(dest)) 
				);
		//操作
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		
		dos.flush();
		dos.close();
		
	}
	
	
}


