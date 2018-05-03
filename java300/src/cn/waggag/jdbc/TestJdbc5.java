package cn.waggag.jdbc;

import java.sql.*;


/**
 * 测试批处理
 * 使用大量数据时,可以使用批处理
 * @author waggag
 * 2018年5月3日 下午6:31:00
 */
public class TestJdbc5 {
	
	public static void main(String[] args) {
		
		Connection con = null;
		Statement smst = null;
		ResultSet rs = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "225514");
			
			con.setAutoCommit(false); //设为手动提交
			long start = System.currentTimeMillis();
			smst = con.createStatement();
			
			for(int i=0;i<200000;i++) {
				smst.addBatch("insert into t_user (username,pwd) values ('waggag"+i+"',661313)");
			}
			smst.executeBatch();
			
			con.commit(); //提交事务
			long end = System.currentTimeMillis();
			System.out.println("插入20000行数据所用时间:"+(end - start));
			
			
			
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
