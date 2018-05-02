package cn.waggag.http;
/**
 * 抽象为一个父类
 * @author wagga
 * 2018年4月22日 下午4:48:42
 */
public abstract class Servlet {
	
	public void service(Request req, Response rep) throws Exception
	{
		this.doGet(req,rep);
		this.doPost(req,rep);
	}
	
	public abstract  void doGet(Request req,Response rep) throws Exception;
	public abstract  void doPost(Request req,Response rep) throws Exception;
}
