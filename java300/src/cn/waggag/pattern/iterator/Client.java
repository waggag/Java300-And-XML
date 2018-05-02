package cn.waggag.pattern.iterator;
/**
 * ����Iteratorģʽ
 * @author waggag
 * 2018��5��2�� ����5:49:49
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
