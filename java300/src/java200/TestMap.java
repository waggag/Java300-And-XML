package java200;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		Map<String, Wife> map = new HashMap<String, Wife>();
		map.put("����",new Wife("��ˬ"));
		map.put("wasd",new Wife("sda"));
		Wife w = (Wife)map.get("����");
		System.out.println("����"+w.name);
	}
}

class Wife{
	String name;
	public Wife(String name) {
		this.name = name;
	}
}