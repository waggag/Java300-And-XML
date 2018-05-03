package cn.waggag.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ����PrepadeStatement�Ļ����÷�
 * @author waggag
 * 2018��5��3�� ����6:31:00
 */
public class TestJdbc3 {
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "225514");
			
			//�ṩռλ��,Ԥ����,Ч�ʽϸ�,���Է�ֹSqlע��
			String sql = "insert into t_user(username,pwd) values(?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, "����");//������1��ʼ����,��������һ������
			ps.setString(2, "225514");
			System.out.println("����һ�м�¼");
			//ps.execute();
			System.out.println(ps.executeUpdate());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null)
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(con != null)
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
