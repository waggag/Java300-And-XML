package cn.waggag.que;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Propetties输出到文件
 * 资源配置文件:
 * 
 * @author wagga
 * 2018年4月14日下午12:42:38
 */
public class TestPropertiesGet {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		//读取绝对路径
		pro.load(new FileReader("f:/db.properties"));
		//读取相对路径
		pro.load(new FileReader("src/db.properties"));
		System.out.println(pro.getProperty(pro.getProperty("user","waggag")));
	}

}
