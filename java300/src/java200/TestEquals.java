package java200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEquals {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		String s1 = new String("aaa");
		String s2 = new String("aaa");
		list.add(s1);
		list.add(s2);
		System.out.println(list.size());
		
		/**
		 * ¼ü²»ÄÜÖØ¸´
		 */
		Map map = new HashMap();
		map.put(s1, "aaaa");
		map.put(s2, "bbbb");
		System.out.println(map.get(s2));
	}
}
