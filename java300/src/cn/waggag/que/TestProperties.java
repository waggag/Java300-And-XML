package cn.waggag.que;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Propetties输出到文件
 * 资源配置文件:
 * 可以动态的切换数据库
 * @author wagga
 * 2018年4月14日下午12:19:58
 */
public class TestProperties {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//创建对象
		Properties pro = new Properties();
		//存储
		pro.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost:1521:oracle");
		pro.setProperty("user", "waggag");
		pro.setProperty("pwd", "tiger");
		
		//获取
		String url = pro.getProperty("url","test");
		System.out.println(url);
		//存储到F:other 绝对路径 
		pro.store(new FileOutputStream(new File("f:/db.properties")), "db配置");
		pro.storeToXML(new FileOutputStream(new File("f:/db.xml")), "db配置");
		//使用相对路径 当前的目录下
		//pro.store(new FileOutputStream(new File("db.properties")), "db配置");
		pro.storeToXML(new FileOutputStream(new File("src/db.properties")), "db配置");
	}
}
