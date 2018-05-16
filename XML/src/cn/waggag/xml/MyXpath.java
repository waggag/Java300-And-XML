package cn.waggag.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MyXpath {

	public static void main(String[] args) {
		try {
			//创建解析工厂
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			//创建解析器
			DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
			//通过解析器读取配置文件,生成一个Document[org.w3c.dom]对象树
			Document document = builder.parse("conf/bookstore.xml");
			
			//创建XPath对象
			XPath xPath = XPathFactory.newInstance().newXPath();
			
//			1.获取bookstore节点下book属性category值为web下的第二个title节点的文本内容
//			 bookstore -> book[@category='web'][2] -> title 
//			 xpath路径：/bookstore/book[@category='web'][2]/title/text()
			String titleXpath = "/bookstore/book[@category='web'][2]/title/text()";
			String titleValue = (String) xPath.evaluate(titleXpath, document, XPathConstants.STRING);
			System.out.println(titleValue);
			
//			2.获取bookstore节点下book属性category值为web的titile属性为en的节点内容
//			bookstore -> book[@category='web'] -> title[@lang='en']
//			xpath路径：/bookstore/book[@category='web']/title[@lang='en']/text()
			String titleLangXpath = "/bookstore/book[@category='web']/title[@lang='en']/text()";
			String titleLangValue = (String) xPath.evaluate(titleLangXpath, document, XPathConstants.STRING);
			System.out.println(titleLangValue);
			
//			 3.获取bookstore下book属性category值为cooking的title的lang属性的值
//			 bookstore -> book[@category='cooking'] -> title ->@lang
//			 xpath路径：/bookstore/book[@category='cooking']/title/@lang
			String titleLangAttrXpath = "/bookstore/book[@category='cooking']/title/@lang";
			String titleLangAttrValue = (String) xPath.evaluate(titleLangAttrXpath, document, XPathConstants.STRING);
			System.out.println(titleLangAttrValue);
			
//			 4.获取bookstore节点下所有book的节点集合
//			 /bookstore/book
			NodeList bookList = (NodeList) xPath.evaluate("/bookstore/book", document, XPathConstants.NODESET);
			//开始遍历bookList
			for(int i = 0; i < bookList.getLength(); i++){
				Element bookElt = (Element) bookList.item(i);
				String titleValue01 = (String) xPath.evaluate("title", bookElt, XPathConstants.STRING);
				String authorValue = (String) xPath.evaluate("author", bookElt, XPathConstants.STRING);
				String year = (String) xPath.evaluate("year", bookElt, XPathConstants.STRING);
				String price = (String) xPath.evaluate("price", bookElt, XPathConstants.STRING);
				System.out.println(titleValue01 + " " + authorValue + " " + year + " " + price);
				System.out.println("---------------");
			}
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}

}
