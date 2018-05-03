package cn.waggag.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试PrepadeStatement的基本用法
 * @author waggag
 * 2018年5月3日 下午6:31:00
 */
public class TestJdbc3 {
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "225514");
			
			//提供占位符,预编译,效率较高,可以防止Sql注入
			String sql = "insert into t_user(username,pwd) values(?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, "王港");//索引从1开始计算,索引代表一行数据
			ps.setString(2, "225514");
			System.out.println("插入一行记录");
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
