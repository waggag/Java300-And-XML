package cn.waggag.jdbc;

import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * ����ClOB,�ı�������ʹ��
 * @author waggag
 * 2018��5��3�� ����8:04:52
 */
public class TestJdbc9 {
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reader r  = null;
		try {
			//����������
//			Class.forName("com.mysql.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","225514");
			//ʹ�ù�����
			con = JDBCUtil.getMysqlConnection();
//			ps = con.prepareStatement("insert into t_user (username,myInfo) values (?,?) ");
//			ps.setString(1, "����");
//			ps.setClob(2, new FileReader(new File("e:/myjava/a.txt")));  //���ı��ļ�����ֱ�����뵽���ݿ���
			
			//�������е��ַ������뵽���ݿ��CLOB�ֶ���
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
