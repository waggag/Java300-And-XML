package cn.waggag.chario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符缓冲流 + 新增方法(不能发生多态)
 * @author waggag
 * 2018年4月15日下午8:06:53
 */
public class BufferReadAndWrite {
	public static void copyPlainText() {
		//创建源
		File src = new File("G:/2.txt");
		File dest = new File("G:/1.txt");
		//选择流
		BufferedWriter wr = null;
		BufferedReader reader = null;
		
		try {
			//加上字符缓冲流
			reader = new BufferedReader (new FileReader(src));
			wr = new BufferedWriter(new FileWriter(dest, true));
			//读取操作
			/*char[] flush = new char[10];
			int len = 0;
			//循环读出所有的数据
			while((len = reader.read(flush)) != -1)
			{
				wr.write(flush, 0, len);
			}*/
			//新增方法
			String line = null;
			while((line = reader.readLine()) != null)
			{
				wr.write(line);
				wr.newLine();
			}
			wr.flush(); //强制刷出
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("源文件不存在");
		} catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("文件读取失败");
		} finally 
		{
			if(wr != null) {
				try {
					wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
		
	}
}
