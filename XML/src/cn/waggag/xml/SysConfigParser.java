package cn.waggag.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 测试Xpath
 * @author 王港
 *
=======

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * dom4和xpath解析xml
 * @author waggag
 * 2018年5月15日 上午8:26:49
>>>>>>> 993402ab54ff5f94d0f907e21419276fe9a56a63
 */
public class SysConfigParser {
	
	public static void main(String[] args) {
		try {
			//创建解析器
			SAXReader reader = new SAXReader();
			//通过解析器的read方法将配置文件读取到内存中,生成一个Document对象树
			Document document = reader.read("conf/sys-config.xml");
			//driver-name节点元素的路径:config -> database-info ->driver-name
			//driver-name节点x-path路径: /config/database-info/driver-name
			Element driverNameElt = (Element) document.selectSingleNode("/config/database-info/driver-name");
			//获取driverNameElt节点元素对象的文本内容
			String driverName = driverNameElt.getStringValue();
			System.out.println(driverName);
			
			//	url节点元素xpath路径:
			//	config/database-info/url
			//	config//url
			//  //url
			Element urlElt = (Element) document.selectSingleNode("config//url");
			String url = urlElt.getStringValue();
			System.out.println(url);
			
			//user元素节点数据的内容
			Element userElt = (Element) document.selectSingleNode("config//user");
			String user = userElt.getTextTrim();
			System.out.println(user);
			
			Element passwdElt = (Element) document.selectSingleNode("//password");
			String passwd = passwdElt.getStringValue();
			System.out.println(passwd);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
