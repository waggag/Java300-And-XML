package cn.waggag.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���Ժ����ݿ⽨������
 * @author waggag
 * 2018��5��3�� ����6:31:00
 */
public class TestJdbc {
	
	public static void main(String[] args) {
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������,�ȽϺķ�ʱ��,���Ӷ����ڲ�������Soket����,��һ��Զ������
			//����������,Ϊ�����Ч��,����ʹ�����ӳ����������Ӷ���
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "225514");
			System.out.println(con);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
