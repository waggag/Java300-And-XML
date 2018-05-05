package cn.waggag.jdbc;

import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 测试ClOB,文本大对象的使用
 * @author waggag
 * 2018年5月3日 下午8:04:52
 */
public class TestJdbc9 {
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reader r  = null;
		try {
			//加载驱动类
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","225514");
			//使用工具类
			con = JDBCUtil.getMysqlConnection();
//			ps = con.prepareStatement("insert into t_user (username,myInfo) values (?,?) ");
//			ps.setString(1, "王港");
//			ps.setClob(2, new FileReader(new File("e:/myjava/a.txt")));  //将文本文件内容直接输入到数据库中
			
			//将程序中的字符串输入到数据库的CLOB字段中
//			ps.setClob(2, new BufferedReader(new InputStreadeamRer(new ByteArrayInputStream("waggag is very goodboy!".getBytes()))));
			
			ps = con.prepareStatement("select * from t_user where id=?");
			ps.setObject(1, 5);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Clob c = rs.getClob("myInfo");
				r  = c.getCharacterStream();
				int temp = 0;
				while((temp=r.read())!=-1){
					System.out.print((char)temp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, con);
		}
	}
}
