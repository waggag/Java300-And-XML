package cn.waggag.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试PrepadeStatement的基本用法
 * @author waggag
 * 2018年5月3日 下午6:31:00
 */
public class TestJdbc4 {
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "225514");
			
			//提供占位符  ?
			String sql = "select id,username,pwd from t_user where id>?";
			ps = con.prepareStatement(sql);
			ps.setObject(1, 2);//把Id大于2的记录取出来
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"---"+rs.getString(2)+"---"+rs.getString(3));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭时按照顺序关闭流
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
