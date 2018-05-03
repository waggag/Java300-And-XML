package cn.waggag.jdbc;

import java.sql.*;
import java.util.Random;


/**
 * ����ʱ�䴦����(java.sql.Date,Time,Timestamp)
 * @author waggag
 * 2018��5��3�� ����8:04:52
 */
public class TestJdbc7 {
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","225514");
			
			for(int i=0;i<100;i++)
			{
				ps = con.prepareStatement("insert into t_user (username,pwd,Time,lastLoginTime) values (?,?,?,?)");

				int rand =  100000000+new Random().nextInt(1000000000);
				
				java.sql.Date date = new java.sql.Date(System.currentTimeMillis()-rand);
				//�����Ҫ����ָ�����ڣ�����ʹ��Calendar��DateFormat
				Timestamp stamp = new Timestamp(System.currentTimeMillis()-rand);  
				
				ps.setObject(1, "����"+i);
				ps.setObject(2, "225514");
				ps.setDate(3, date);
				ps.setTimestamp(4, stamp);
				
				ps.execute();
			}
			
			System.out.println("����ɹ�!");
			
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
