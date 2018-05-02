package cn.waggag.server;

import java.util.HashMap;
import java.util.Map;

/**
 * ������
 * @author wagga
 * 2018��4��22�� ����6:26:52
 */
public class ServletContext {
	//Ϊÿһ��servletȡ������
	private Map<String,String> servlet;
	//url -->login
	//  /log -->login
	//     /login -->login
	private Map<String,String> mapping;
	
	public ServletContext() {
		servlet = new HashMap<String, String>();
		mapping = new HashMap<String, String>();
	}

	public Map<String, String> getServlet() {
		return servlet;
	}

	public void setServlet(Map<String, String> servlet) {
		this.servlet = servlet;
	}

	public Map<String, String> getMapping() {
		return mapping;
	}

	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
	
}
