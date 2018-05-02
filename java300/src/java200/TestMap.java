package java200;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		Map<String, Wife> map = new HashMap<String, Wife>();
		map.put("王港",new Wife("孟爽"));
		map.put("wasd",new Wife("sda"));
		Wife w = (Wife)map.get("王港");
		System.out.println("王港"+w.name);
	}
}

class Wife{
	String name;
	public Wife(String name) {
		this.name = name;
	}
}