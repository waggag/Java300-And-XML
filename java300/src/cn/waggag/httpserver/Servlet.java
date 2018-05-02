package cn.waggag.httpserver;

public class Servlet {
	
	public void service(Request req, Response rep)
	{
	
		//响应请求
		rep.println("<html><head><title>HTTP</title>");
		rep.println("</head><body>");
		rep.println("欢迎:").println(req.getParameter("uname")).println("回来!");
		rep.println("</body></html>");

		
	}

}
