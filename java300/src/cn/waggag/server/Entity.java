package cn.waggag.server;
/*
 * <servlent>
 *		<servlet-name>login</servlet-name>
 *		<servlent-class>cn.waggag.http.LoginServlet</servlent-class>
 *	</servlent>
 * 
 */
public class Entity {
	
	private String name;
	private String clz;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClz() {
		return clz;
	}
	public void setClz(String clz) {
		this.clz = clz;
	}

}
