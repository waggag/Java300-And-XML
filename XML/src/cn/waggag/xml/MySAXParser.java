package cn.waggag.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 测试SAX解析XML文件
 * @author waggag
 * 2018年5月14日 下午8:54:39
 */
public class MySAXParser {
	
	public static void main(String[] args) {
		try {
			//创建解析器工厂
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			//创建解析器
			SAXParser saxParser = saxParserFactory.newSAXParser();
			//通过解析器parser
			saxParser.parse("conf/persons.xml", new MyDefaultHander());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}


class MyDefaultHander extends DefaultHandler{

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.print("<" + qName + ">");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.print(new String(ch, start, length));
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.print("</" + qName + ">");
	}

}

