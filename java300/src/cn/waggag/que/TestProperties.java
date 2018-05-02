package cn.waggag.que;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ʹ��Propetties������ļ�
 * ��Դ�����ļ�:
 * ���Զ�̬���л����ݿ�
 * @author wagga
 * 2018��4��14������12:19:58
 */
public class TestProperties {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//��������
		Properties pro = new Properties();
		//�洢
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:oracle");
		pro.setProperty("user", "waggag");
		pro.setProperty("pwd", "tiger");
		
		//��ȡ
		String url = pro.getProperty("url","test");
		System.out.println(url);
		//�洢��F:other ����·�� 
		pro.store(new FileOutputStream(new File("f:/db.properties")), "db����");
		pro.storeToXML(new FileOutputStream(new File("f:/db.xml")), "db����");
		//ʹ�����·�� ��ǰ��Ŀ¼��
		//pro.store(new FileOutputStream(new File("db.properties")), "db����");
		pro.storeToXML(new FileOutputStream(new File("src/db.properties")), "db����");
	}
}
