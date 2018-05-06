package cn.waggag.core;
/**
 * 根据配置信息,维持连接对象的管理
 * @author waggag
 * 2018年5月5日 下午12:14:37
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import cn.waggag.bean.Configuration;

public class DBManager {
	
	private static Configuration conf;
	
	/**
	 * 静态代码块,通过配置文件来读取所需要的信息
	 */
	static { 
		Properties pros = new Properties();
		
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		conf = new Configuration();
		conf.setDriver(pros.getProperty("driver"));
		conf.setPoPackage(pros.getProperty("poPackage"));
		conf.setPwd(pros.getProperty("pwd"));
		conf.setSrcPath(pros.getProperty("srcPath"));
		conf.setUrl(pros.getProperty("url"));
		conf.setUser(pros.getProperty("user"));
		conf.setUsingDB(pros.getProperty("usingDB"));
	}
	
	/**
	 * 创建连接池的对象
	 * @return
	 */
	public static Connection getConnection(){
		try {
			Class.forName(conf.getDriver());
			return DriverManager.getConnection(conf.getUrl(),
					conf.getUser(),conf.getPwd());     //直接建立连接，后期增加连接池处理，提高效率！！！
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 创建新的连接
	 * @return
	 */
	public static Connection createConnection(){
		try {
			Class.forName(conf.getDriver());
			return DriverManager.getConnection(conf.getUrl(),
					conf.getUser(),conf.getPwd());     //直接建立连接，后期增加连接池处理，提高效率！！！
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 关闭ResultSet rs,Statement ps,Connection conn
	 */
	public static void close(ResultSet rs,Statement ps,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(ps!=null){
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement ps,Connection conn){
		try {
			if(ps!=null){
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn){
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 返回Configuration对象,用于类类型的生成
	 * @return
	 */
	public static Configuration getConf(){
		return conf;
	}
}
