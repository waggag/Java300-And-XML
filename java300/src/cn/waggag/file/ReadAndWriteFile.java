package cn.waggag.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author waggag
 * 2018年4月15日下午3:21:22
 */
public class ReadAndWriteFile {
	
	public static void main(String[] args) {
		readFile();
		writeFile();
	}
	public static void writeFile() {
		//1.建立联系 File对象 目的的
		File dest = new File("G:/1.txt");
		//2.选择流 文件输入流  OutputStream  FileOutputStream
		OutputStream os = null;
		try {
			//已追加的形式写出文件,必须为true,否则覆盖原有文件
			os = new FileOutputStream(dest, true);
			//3.操作
			String str = "waggag is very goods!\r\n";
			//字符串转自己数组
			byte[] data = str.getBytes();
			os.write(data, 0, data.length);
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}finally{
			//释放资源
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
		
	}

	/**
	 * 读文件的测试
	 * 	1.建立联系  File对象
	 *	2.选择流  文件输入流  InputStream  FileInputStream
	 * 	3.操作	读取文件的大小
	 *	4.释放资源
	 */
	public static void readFile() {
		//1.建立联系
		File src = new File("G:/1.txt");
		InputStream is = null;
		//2.选择流
		try {
			is= new FileInputStream(src);
			//3.操作不断的读取文件中的信息
			byte[] car = new byte[5];
			int len = 0; // 实际读取的大小
			//循环读取
			while((len = is.read(car)) != -1)
			{
				//输出字节数组转换的字符串
				String info = new String(car, 0, len);
				System.out.println(info);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//释放资源
			if(is != null)
			{
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
