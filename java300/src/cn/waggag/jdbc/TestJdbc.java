package cn.waggag.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试和数据库建立连接
 * @author waggag
 * 2018年5月3日 下午6:31:00
 */
public class TestJdbc {
	
	public static void main(String[] args) {
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接,比较耗费时间,连接对象内部包含了Soket对象,是一个远程连接
			//真正开发中,为了提高效率,都会使用连接池来管理连接对象
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "225514");
			System.out.println(con);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
