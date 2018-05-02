package cn.waggag.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestPrintStream {
	
	public static void main(String[] args) throws FileNotFoundException{
		//重定向
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("E:/1.txt")), true));
		
		System.out.println("wanggang is very good!");  //控制台--->文件
		//回控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)), true));
		System.out.println(566);
		
	}
	
	public static void filePrint() throws FileNotFoundException {
		InputStream is = System.in; //键盘输入
		is = new BufferedInputStream(new FileInputStream("E:/1.txt"));
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(is);
		System.out.println("请输入：");
		System.out.println(sc.nextLine());	
	}
	
	public static void print() throws FileNotFoundException {
		System.out.println("test");
		//输出到文件
		File src = new File("E:/1.txt")	;
		PrintStream	ps = null;
		
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(src)));
	
		ps.println("io is so easy");
		ps.flush();
		ps.close();	
			
	}
	
}
