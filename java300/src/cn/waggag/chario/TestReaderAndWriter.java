package cn.waggag.chario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 纯文本读取和写出
 * @author waggag
 * 2018年4月15日下午7:10:50
 */
public class TestReaderAndWriter {
	
	public static void main(String[] args) {
		copyPlainText();
	}
	
	public static void copyPlainText() {
		//创建源
		File src = new File("G:/2.txt");
		File dest = new File("G:/1.txt");
		//选择流
		Writer wr = null;
		Reader reader = null;
		
		try {
			reader =  new FileReader(src);
			wr = new FileWriter(dest, true);
			//读取操作
			char[] flush = new char[10];
			int len = 0;
			//循环读出所有的数据
			while((len = reader.read(flush)) != -1)
			{
				wr.write(flush, 0, len);
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
		
	/**
	 * 纯文本的写入
	 */
	public static void writerText() {
		
		//创建源
		File dest = new File("G:/2.txt");
		//选择流
		Writer wr = null;
		try {
			wr = new FileWriter(dest,true);//追加文件，而不是覆盖文件，默认为覆盖文件
			//写出
			String msg = "waggag is very good!\r\n";
			wr.write(msg);
			wr.append("he is very goods!\r\n");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(wr != null)
			{
				try {
					wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * 纯文本的读取
	 */
	@SuppressWarnings("unused")
	public static void readText() {
		//创建源
		File src = new File("G:/1.txt");
		//选择流
		Reader reader = null;
		try {
			reader =  new FileReader(src);
			//读取操作
			char[] flush = new char[10];
			int len = 0;
			while((len = reader.read(flush)) != -1)
			{
				//字符数组转为字符串
				String str = new String(flush);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("源文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件读取失败");
		} finally {
			if(reader != null)
			{
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	
	}
}
