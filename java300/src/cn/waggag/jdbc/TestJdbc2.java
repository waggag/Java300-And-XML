package cn.waggag.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ����ִ��Sql���,�Լ�Sqlע��
 * @author waggag
 * 2018��5��3�� ����6:31:00
 */
public class TestJdbc2 {
	
	public static void main(String[] args) {
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//��������,�ȽϺķ�ʱ��,���Ӷ����ڲ�������Soket����,��һ��Զ������
			//����������,Ϊ�����Ч��,����ʹ�����ӳ����������Ӷ���
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "225514");
			
			Statement stmt = con.createStatement();
//			String sql = "SELECT * FROM `t_user`;";
//			stmt.execute(sql);
			
			//����Sqlע��,�����������������ݿ�
			String id = "5 or 1 = 1";
			String sql = "delete from t_user where id="+id;
			stmt.execute(sql);
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
