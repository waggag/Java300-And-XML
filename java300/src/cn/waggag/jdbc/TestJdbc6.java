package cn.waggag.jdbc;

import java.sql.*;


/**
 * ��������Ļ�������
 * @author waggag
 * 2018��5��3�� ����8:04:52
 */
public class TestJdbc6 {
	
	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","225514");
			
			con.setAutoCommit(false); //JDBC��Ĭ����true���Զ��ύ����
			
			ps1 = con.prepareStatement("insert into t_user (username,pwd) values (?,?)");
			ps1.setObject(1, "����");
			ps1.setObject(2, "123456");
			ps1.execute();
			System.out.println("����һ���û�,����");
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			ps2 = con.prepareStatement("insert into t_user (username,pwd) values (?,?,?)");
			ps2.setObject(1, "��ˬ");
			ps2.setObject(2, "123456");
			ps2.execute();			
			System.out.println("����һ���û�,��ˬ");
			
			
			con.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			try {
				con.rollback();	//�ع�
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps1!=null){
					ps1.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
