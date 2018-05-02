package java200;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * 存储对象,对简单的xml进行解析
 * @author waggag
 * 2018年4月22日 下午8:06:35
 */
public class PersonHandler extends DefaultHandler{
	
	private List<Person> persons;
	
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	private Person person;
	
	private String tag;

	@Override
	public void startDocument() throws SAXException {
		System.out.println("处理文档开始");
		persons = new ArrayList<Person>();
	}
	
	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		System.out.println("开始一个元素"+arg2);
		if(arg2 != null)
		{
			tag = arg2;
		}
		if(null != arg2 && arg2.equals("person"))
		{
			person = new Person();
		}
	}
	
	
	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		System.out.println(new String(arg0, arg1, arg2));
		String str = new String(arg0, arg1, arg2);
		if(tag != null && tag.equals("name"))
		{
			person.setName(str);
		}else if(tag != null && tag.equals("age"))
		{
			Integer age = Integer.valueOf(str);
			person.setAge(age);
		}
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("处理文档结束");
	}

	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		System.out.println("结束一个元素"+arg2);
		if(arg2.equals("person"))
		{
			this.persons.add(person);
		}
		tag = null;
	}
	
}
