package cn.waggag.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试执行Sql语句,以及Sql注入
 * @author waggag
 * 2018年5月3日 下午6:31:00
 */
public class TestJdbc2 {
	
	public static void main(String[] args) {
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接,比较耗费时间,连接对象内部包含了Soket对象,是一个远程连接
			//真正开发中,为了提高效率,都会使用连接池来管理连接对象
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "225514");
			
			Statement stmt = con.createStatement();
//			String sql = "SELECT * FROM `t_user`;";
//			stmt.execute(sql);
			
			//测试Sql注入,利用这点可以侵入数据库
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
