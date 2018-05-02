package java200;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * ��ȡ��������
 * @author wagga
 * 2018��4��22�� ����7:57:59
 */
public class Parse {
	public static void main(String[] args) 
			throws ParserConfigurationException, SAXException, IOException {
		//1.��ȡ��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.�ӽ���������ȡ������
		SAXParser parse = factory.newSAXParser();
		//3.���ý������ƶ��������������ĵ��ƶ�������
		//4.��д������
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
