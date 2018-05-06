package cn.waggag.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.waggag.core.DBManager;

/**
 * ���ݿ����ӳ�
 * @author waggag
 * 2018��5��6�� ����10:45:30
 */
@SuppressWarnings("all")
public class DBConnectionPool {
	/**
	 * ���ӳ�
	 */
	private List<Connection> pool;
	/**
	 * ���������
	 */
	private static final int POOL_MAX_SIZE = 10;
	/**
	 * ��С������
	 */
	private static final int POOL_MIN_SIZE = 10;
	
	public DBConnectionPool() {
		initPool();
	}
	
	/**
	 * ��ʼ�����ӳ�,ʹ���е��������ﵽ��Сֵ
	 */
	public void initPool() {
		if(pool == null) {
			pool = new ArrayList<Connection>();
		}
		while(pool.size()<DBConnectionPool.POOL_MIN_SIZE) {
			pool.add(DBManager.createConnection());
			System.out.println("��ʼ������������"+pool.size());
		}
	}
	/**
	 * �ӳ���ȡһ������
	 */
	public synchronized Connection getConnection()
	{
		int last_index = pool.size()-1;
		Connection con = pool.get(last_index);
		pool.remove(last_index);
		return con;
	}
	/**
	 * �ر�Connection���������Ĺر�,���Ƿŵ����ӳ���
	 */
	public synchronized void close(Connection con)
	{
		if(pool.size() >= POOL_MAX_SIZE)
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			pool.add(con);	
		}
	}
	
}
