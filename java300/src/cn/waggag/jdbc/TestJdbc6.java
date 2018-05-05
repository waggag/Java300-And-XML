package cn.waggag.jdbc;

import java.sql.*;


/**
 * 测试事务的基本概念
 * @author waggag
 * 2018年5月3日 下午8:04:52
 */
public class TestJdbc6 {
	
	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","225514");
			
			con.setAutoCommit(false); //JDBC中默认是true，自动提交事务
			
			ps1 = con.prepareStatement("insert into t_user (username,pwd) values (?,?)");
			ps1.setObject(1, "王港");
			ps1.setObject(2, "123456");
			ps1.execute();
			System.out.println("插入一个用户,王港");
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			ps2 = con.prepareStatement("insert into t_user (username,pwd) values (?,?,?)");
			ps2.setObject(1, "孟爽");
			ps2.setObject(2, "123456");
			ps2.execute();			
			System.out.println("插入一个用户,孟爽");
			
			
			con.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			try {
				con.rollback();	//回滚
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
