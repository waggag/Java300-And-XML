package cn.waggag.testorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ʹ��Javabean��������װһ����¼
 * ʹ��List<Javabean>�洢������¼
 * @author waggag
 * 2018��5��5�� ����9:26:34
 */
public class TestOrm3 {
	
	public static void test01(){
		Connection conn = JDBCUtil.getMysqlConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Emp emp = null;
		try {
			ps = conn.prepareStatement("select empname,salary,age from emp where id=?");
			ps.setObject(1, 1);
			rs = ps.executeQuery();
			while(rs.next()){
//				System.out.println(rs.getString(1)+"--"+rs.getDouble(2)+"--"+rs.getInt(3));
				emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		
		System.out.println(emp.getEmpname()+"-"+emp.getSalary()+"-"+emp.getAge());
	}
	
	public static void test02(){
		Connection conn = JDBCUtil.getMysqlConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> list= new ArrayList<Emp>();
		try {
			ps = conn.prepareStatement("select empname,salary,age from emp where id>?");
			ps.setObject(1, 0);
			rs = ps.executeQuery();
			while(rs.next()){
				Emp emp = new Emp(rs.getString(1),rs.getDouble(2),rs.getInt(3));
				list.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, conn);
		}
		
		//����List�����Ǳ�����һ�еĶ��е���Ϣ
		for(Emp emp:list){
			System.out.println(emp.getEmpname()+"-"+emp.getSalary()+"-"+emp.getAge());
		}
	}
	
	public static void main(String[] args) {
		test02();
	}
}
