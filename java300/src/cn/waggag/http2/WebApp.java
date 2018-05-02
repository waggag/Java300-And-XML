package cn.waggag.http2;

import java.util.Map;

public class WebApp {
	private static ServletContext context;
	static {
		
		context = new ServletContext();
		
		Map<String,String> mapping = context.getMapping();
		mapping.put("/login", "login");
		mapping.put("/log", "login");
		mapping.put("/reg", "register");
		
		Map<String, String> servlet = context.getServlet();
		servlet.put("login", "cn.waggag.http.LoginServlet");
		servlet.put("register", "cn.waggag.http2.RegisterServlet");
	}
	
	@SuppressWarnings("deprecation")
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		if(null == url || (url=url.trim()).equals(""))
		{
			return null;
		}
		//�����ַ���(��������)��������
		//return context.getServlet().get(context.getMapping().get(url));
		String name = context.getServlet().get(context.getMapping().get(url));
		//ȷ���չ���Ĵ���
		return (Servlet) Class.forName(name).newInstance();
	
	
	
	
	}
	
	
	
	
}
