package java100;

import java.io.File;
import java.io.IOException;

public class TestFile {
	public static void main(String[] args) {
		File f = new File("E:/1.txt");
		File f2= new File("d:/git");
		/**
		 * ����ļ���ʲô����
		 */
		if(f.isFile())
		{
			System.out.println("��һ���ļ�");
		}
		if(f2.isDirectory())
		{
			System.out.println("��һ��Ŀ¼");
		}
		System.out.println(f2.lastModified());
		System.out.println(f2.getName());
		
		System.out.println("######################");
		/**
		 * ����һ���ļ�
		 */
		File f3=new File("E:/1.java");
		try {
			f3.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * ɾ��һ���ļ�
		 */
		f3.delete();
		f.delete();
		/**
		 * mkdris �� mkdirһ������һ��Ŀ¼,һ�������������Ŀ¼
		 */
		File f4 = new File("E:/ass/saf/fasf/asfa");
		f4.mkdirs();
	}
}
