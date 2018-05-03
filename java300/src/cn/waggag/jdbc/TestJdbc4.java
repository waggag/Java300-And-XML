package cn.waggag.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ����PrepadeStatement�Ļ����÷�
 * @author waggag
 * 2018��5��3�� ����6:31:00
 */
public class TestJdbc4 {
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "225514");
			
			//�ṩռλ��  ?
			String sql = "select id,username,pwd from t_user where id>?";
			ps = con.prepareStatement(sql);
			ps.setObject(1, 2);//��Id����2�ļ�¼ȡ����
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//�ر�ʱ����˳��ر���
			try {
				if(rs != null)
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
