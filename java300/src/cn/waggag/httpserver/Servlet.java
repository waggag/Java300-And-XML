package cn.waggag.httpserver;

public class Servlet {
	
	public void service(Request req, Response rep)
	{
	
		//��Ӧ����
		rep.println("<html><head><title>HTTP</title>");
		rep.println("</head><body>");
		rep.println("��ӭ:").println(req.getParameter("uname")).println("����!");
		rep.println("</body></html>");

		
	}

}
