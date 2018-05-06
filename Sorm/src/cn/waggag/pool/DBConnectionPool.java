package cn.waggag.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.waggag.core.DBManager;

/**
 * 数据库连接池
 * @author waggag
 * 2018年5月6日 上午10:45:30
 */
@SuppressWarnings("all")
public class DBConnectionPool {
	/**
	 * 连接池
	 */
	private List<Connection> pool;
	/**
	 * 最大连接数
	 */
	private static final int POOL_MAX_SIZE = 10;
	/**
	 * 最小连接数
	 */
	private static final int POOL_MIN_SIZE = 10;
	
	public DBConnectionPool() {
		initPool();
	}
	
	/**
	 * 初始化连接池,使池中的连接数达到最小值
	 */
	public void initPool() {
		if(pool == null) {
			pool = new ArrayList<Connection>();
		}
		while(pool.size()<DBConnectionPool.POOL_MIN_SIZE) {
			pool.add(DBManager.createConnection());
			System.out.println("初始化池中连接数"+pool.size());
		}
	}
	/**
	 * 从池中取一个连接
	 */
	public synchronized Connection getConnection()
	{
		int last_index = pool.size()-1;
		Connection con = pool.get(last_index);
		pool.remove(last_index);
		return con;
	}
	/**
	 * 关闭Connection不是真正的关闭,而是放到连接池中
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
