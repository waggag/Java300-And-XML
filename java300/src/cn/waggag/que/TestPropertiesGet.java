package cn.waggag.que;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * ʹ��Propetties������ļ�
 * ��Դ�����ļ�:
 * 
 * @author wagga
 * 2018��4��14������12:42:38
 */
public class TestPropertiesGet {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		//��ȡ����·��
		pro.load(new FileReader("f:/db.properties"));
		//��ȡ���·��
		pro.load(new FileReader("src/db.properties"));
		System.out.println(pro.getProperty(pro.getProperty("user","waggag")));
	}

}
