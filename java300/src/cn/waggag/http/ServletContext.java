package cn.waggag.http;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文
 * @author wagga
 * 2018年4月22日 下午6:26:52
 */
public class ServletContext {
	//为每一个servlet取个别名
	private Map<String,Servlet> servlet;
	//url -->login
	//  /log -->login
	//     /login -->login
	private Map<String,String> mapping;
	
	public ServletContext() {
		servlet = new HashMap<String, Servlet>();
		mapping = new HashMap<String, String>();
	}

	public Map<String, Servlet> getServlet() {
		return servlet;
	}

	public void setServlet(Map<String, Servlet> servlet) {
		this.servlet = servlet;
	}

	public Map<String, String> getMapping() {
		return mapping;
	}

	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
	
}
