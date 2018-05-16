package cn.waggag.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ServerParser {
	
	public static void main(String[] args) {
		try {
			//创建解析器
			SAXReader saxReader = new SAXReader();
			//通过解析器的read方法将配置文件读取到内存中
			Document documnet = saxReader.read("conf/server.xml");
			//获取connector节点元素的对象路径
			Element connecotElt = (Element) documnet.selectSingleNode("//connector");
			//获取connectorElt节点元素的属性对象
			Attribute portAttr = connecotElt.attribute("port");
			//获取portAttr属性对象的值
			String port = portAttr.getStringValue();
			
			//
			String portValue = connecotElt.attributeValue("port");
			
			
			System.out.println(portValue);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}
}
