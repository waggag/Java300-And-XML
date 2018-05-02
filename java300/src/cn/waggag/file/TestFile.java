package cn.waggag.file;

import java.io.File;

/**
 * 2�����ó���
 * 1.·���ָ��� ;
 * 2.�ļ��ָ��
 * windows \     linux  /
 * @author waggag
 * 2018��4��15������10:46:44
 */
public class TestFile {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//·����ʾ
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		String path = "D:/Git/1.bmp";
		//��̬����ʱʹ��
		path = "D:"+File.separator+"Git"+File.separator+"1.bmp";
		//�Ƽ�ʹ��
		path = "D:/Git/1.bmp";
		
		
		/**
		 * ���·�������·��
		 */
		String parentPath = "E:/xp/test";
		String name = "2.jpg";
		//���·��
		System.out.println("======���·��=====");
		File src = new File(parentPath,name);
		src = new File(new File(parentPath), name);
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//����·��
		System.out.println("======����·��=====");
		src = new File("E:/xp/test/2.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//û���̷�����user.dir����
		src = new File("test.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
		
		
	}
}
