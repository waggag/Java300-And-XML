package cn.waggag.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装了JDBC查询常用的操作
 * @author waggag
 * 2018年5月5日 下午12:17:16
 */

public class JDBCUtils {

	/**
	 * 给sql传参
	 * @param ps  预编译sql语句对象
	 * @param params 参数
	 */
	public static void handleParams(PreparedStatement ps, Object[] params) {

		if(params != null) {
			for(int i=0;i<params.length;i++) {
				try {
					ps.setObject(i+1, params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
}
