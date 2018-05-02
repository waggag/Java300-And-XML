package cn.waggag.http2;

public class LoginServlet extends Servlet {

	@Override
	public void doPost(Request req, Response rep) throws Exception {
		
	}

	@Override
	public void doGet(Request req, Response rep) throws Exception {
//		
//		rep.println("<html><head><title>»¶Ó­»ØÀ´!</title>");
//		rep.println("</head><body>");
//		rep.println("»¶Ó­:").println(req.getParameter("uname")).println("»ØÀ´!");
//		rep.println("</body></html>");

		
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		
		if(login(name,pwd)){
			rep.println("µÇÂ½³É¹¦");
		}else {
			rep.println("µÇÂ½Ê§°Ü");
		}
	}
	
	public boolean login(String name, String pwd)
	{
		return name.equals("waggag") && pwd.equals("225514");
	}
	
}