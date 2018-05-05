package cn.waggag.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ��װ��JDBC��ѯ���õĲ���
 * @author waggag
 * 2018��5��5�� ����12:17:16
 */

public class JDBCUtils {

	/**
	 * ��sql����
	 * @param ps  Ԥ����sql������
	 * @param params ����
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
