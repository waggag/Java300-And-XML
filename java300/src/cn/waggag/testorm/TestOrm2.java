package cn.waggag.testorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ����ʹ��Object[]����װһ̨Ŷ��¼
 * ʹ��List<Onject[]> �洢������¼
 * @author waggag
 * 2018��5��5�� ����8:15:49
 */
public class TestOrm2 {
	
	public static void main(String[] args) {
		Connection con = JDBCUtil.getMysqlConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			
			ps = con.prepareStatement("select empname,salary from emp where id>?");
			ps.setObject(1, 1);
			rs = ps.executeQuery();
			Object[] objs = new Object[2];
			
			while(rs.next()) {
				//System.out.println(rs.getString(1)+"--"+rs.getDouble(2));
				objs[0] = rs.getString(1);
				objs[1] = rs.getDouble(2);
				list.add(objs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, con);
		}
		for(Object[] objs:list) {
			System.out.println(objs[0]+"--"+objs[1]);
		}
	}
}
