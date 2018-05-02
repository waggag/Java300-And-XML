package cn.waggag.pattern.iterator;
/**
 * 测试Iterator模式
 * @author waggag
 * 2018年5月2日 下午5:49:49
 */
public class Client {
	
	public static void main(String[] args) {
		Conrete c = new Conrete();
		c.addObject("aaa");
		c.addObject("bbb");
		c.addObject("ccc");
		
		MyIterator iter = c.createinverseIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
