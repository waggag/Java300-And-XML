package cn.waggag.xml;

import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * xml的解析
 * @author waggag
 * 2018年5月14日 下午8:29:18
 */
public class Dom4jTest {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			//创建解析器
			SAXReader reader = new SAXReader();
			//通过解析器read方法将解析器读到内存中,生成一个Document对象树
			Document document = reader.read("conf/students.xml");
			//获取根节点
			Element root = document.getRootElement();
			//遍历根节点
			for(Iterator<Element> rootIter = root.elementIterator();rootIter.hasNext();)
			{
				Element student = rootIter.next();
				for(Iterator<Element> innerIter = student.elementIterator();innerIter.hasNext();)
				{
					Element innerElt = innerIter.next();
					String innerValue = innerElt.getStringValue();
					System.out.println(innerValue);
				}
				System.out.println("================");
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
