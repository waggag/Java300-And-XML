
package cn.waggag.http;


public class RegisterServlet extends Servlet {

	@Override
	public void doGet(Request req, Response rep) throws Exception {
		
		rep.println("<html><head><title����ע��</title>");
		rep.println("</head><body>");
		rep.println("����û�����"+req.getParameter("uname"));
		rep.println("</body></html>");
	}

	@Override
	public void doPost(Request req, Response rep) throws Exception {
	}

}