package cn.waggag.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * 测试时间处理类(java.sql.Date,Time,Timestamp),取出指定时间段的内容
 * @author waggag
 * 2018年5月3日 下午8:04:52
 */
public class TestJdbc8 {
	/**
	 * 将字符串代表的日期转为long数字
	 * @param dateStr
	 * @return
	 */
	public static long strDate(String dateStr)
	{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return format.parse(dateStr).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","225514");
			
//			ps = con.prepareStatement("select * from t_user where Time>? and Time<?");
//			java.sql.Date start = new java.sql.Date(strDate("2018-4-3 10:23:45"));
//			java.sql.Date end = new java.sql.Date(strDate("2018-5-13 10:23:45"));
//			ps.setObject(1, start);
//			ps.setObject(2, end);
			
			ps = con.prepareStatement("select * from t_user where lastLoginTime>? and lastLoginTime<?  order by lastLoginTime ");
			Timestamp start = new Timestamp(strDate("2018-5-1 8:10:20"));
			Timestamp end = new Timestamp(strDate("2018-5-1  9:9:10"));
			//使用占位符,可以防止sql注入
			ps.setObject(1, start);
			ps.setObject(2, end);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("id")+"--"+rs.getString("username")+"--"+rs.getTimestamp("lastLoginTime"));
			}	
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps != null){
					ps.close();
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
