package cn.waggag.chario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流 字节转为字符
 * 1.输出流   OutputStreamWriter 编码
 * 2.输入流	InputerStreamReader 解码
 * @author waggag
 * 2018年4月15日下午8:33:31
 */
public class SwitchStream {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//指定解码字符集
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(new File("G:/2.txt")),"utf-8")
				);
		//写出文件
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("G:/1.txt",true)
				);
		String info = null;
		while((info = br.readLine()) != null)
		{
			System.out.println(info);
			bw.write(info);
			bw.newLine();
		}
		bw.flush();
		br.close();
	}
}
