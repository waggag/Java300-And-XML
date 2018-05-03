package cn.waggag.jdbc;

import java.sql.*;


/**
 * ����������
 * ʹ�ô�������ʱ,����ʹ��������
 * @author waggag
 * 2018��5��3�� ����6:31:00
 */
public class TestJdbc5 {
	
	public static void main(String[] args) {
		
		Connection con = null;
		Statement smst = null;
		ResultSet rs = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "225514");
			
			con.setAutoCommit(false); //��Ϊ�ֶ��ύ
			long start = System.currentTimeMillis();
			smst = con.createStatement();
			
			for(int i=0;i<200000;i++) {
				smst.addBatch("insert into t_user (username,pwd) values ('waggag"+i+"',661313)");
			}
			smst.executeBatch();
			
			con.commit(); //�ύ����
			long end = System.currentTimeMillis();
			System.out.println("����20000����������ʱ��:"+(end - start));
			
			
			
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
				if(smst != null)
				smst.close();
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
