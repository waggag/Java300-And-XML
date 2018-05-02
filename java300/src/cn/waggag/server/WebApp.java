package cn.waggag.server;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import cn.waggag.servlet.Servlet;

public class WebApp {
	private static ServletContext context;
	static {

		try {
			//获取解析工厂
			SAXParserFactory factory = SAXParserFactory.newInstance();
			//获取解析器
			SAXParser sax = factory.newSAXParser();
			//指定xml+处理器
			WebHander webhander = new WebHander();
			sax.parse(Thread.currentThread().getContextClassLoader().
					getResourceAsStream("WEB_INFO\\web.xml"), webhander);
		
			//将List转成Map
			context = new ServletContext();
			
			Map<String, String> servlet = context.getServlet();
			
			//serylet-name  servelt-class
			for(Entity entity: webhander.getEntityList()) {
				servlet.put(entity.getName(), entity.getClz());
			}
			
			//url-pattern servlet-name
			Map<String,String> mapping = context.getMapping();
			for(Mapping mapp: webhander.getMappingList())
			{
				List<String> urls = mapp.getUrlPattern();
				for(String url: urls) {
					mapping.put(url, mapp.getName());
				}
			}
		
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@SuppressWarnings("deprecation")
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		if(null == url || (url=url.trim()).equals(""))
		{
			return null;
		}
		//根据字符串(完整对象)创建对象
		//return context.getServlet().get(context.getMapping().get(url));
		String name = context.getServlet().get(context.getMapping().get(url));
		//确保空构造的存在
		return (Servlet) Class.forName(name).newInstance();

	}

}
