package cn.waggag.http2;

public class LoginServlet extends Servlet {

	@Override
	public void doPost(Request req, Response rep) throws Exception {
		
	}

	@Override
	public void doGet(Request req, Response rep) throws Exception {
//		
//		rep.println("<html><head><title>��ӭ����!</title>");
//		rep.println("</head><body>");
//		rep.println("��ӭ:").println(req.getParameter("uname")).println("����!");
//		rep.println("</body></html>");

		
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		
		if(login(name,pwd)){
			rep.println("��½�ɹ�");
		}else {
			rep.println("��½ʧ��");
		}
	}
	
	public boolean login(String name, String pwd)
	{
		return name.equals("waggag") && pwd.equals("225514");
	}
	
}