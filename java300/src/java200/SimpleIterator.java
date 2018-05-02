package java200;
/**
 * 不同的思路实现Iterator
 * @author 王港
 * 2018年4月10日 下午7:38:41
 */
public class SimpleIterator {
	private String[] elem = {"a","b","c"};
	
	private int size = elem.length;
	
	//指针,游标
	private int coursor = -1;
	
	//判断是否存在下一个
	public boolean hasNext() {
		return coursor+1<size;
	}
	//获取下一个
	public String next() {
		coursor++;
		return elem[coursor];
	}
	//删除下一个
	public void remove() {
		System.arraycopy(elem, coursor+1, elem, coursor, this.size-coursor-1);
		this.size--;
		coursor--;
	}
	public int size() {
		return this.size;
	}
	public static void main(String[] args) {
		SimpleIterator list = new SimpleIterator();
		//先判断,后获取值
		while(list.hasNext()) {
			System.out.println(list.next());
			list.remove();
		}
		System.out.println(list.size);
	}
}
