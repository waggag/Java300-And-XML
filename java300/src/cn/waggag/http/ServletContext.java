package cn.waggag.http;

import java.util.HashMap;
import java.util.Map;

/**
 * ������
 * @author wagga
 * 2018��4��22�� ����6:26:52
 */
public class ServletContext {
	//Ϊÿһ��servletȡ������
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
