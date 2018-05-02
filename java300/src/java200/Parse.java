package java200;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * 获取解析工厂
 * @author wagga
 * 2018年4月22日 下午7:57:59
 */
public class Parse {
	public static void main(String[] args) 
			throws ParserConfigurationException, SAXException, IOException {
		//1.获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.从解析工厂获取解析器
		SAXParser parse = factory.newSAXParser();
		//3.利用解析器制定处理器，加载文档制定处理器
		//4.编写处理器
		PersonHandler hander = new PersonHandler();
		parse.parse(Thread.currentThread().getContextClassLoader().
				getResourceAsStream("java200/person.xml")
				,hander);
		List<Person> persons = (List<Person>) hander.getPersons();
		for(Person temp: persons)
		{
			System.out.println(temp.getName()+"-->"+temp.getAge());
		}
		
	}
}
