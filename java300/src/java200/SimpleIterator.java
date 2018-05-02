package java200;
/**
 * ��ͬ��˼·ʵ��Iterator
 * @author ����
 * 2018��4��10�� ����7:38:41
 */
public class SimpleIterator {
	private String[] elem = {"a","b","c"};
	
	private int size = elem.length;
	
	//ָ��,�α�
	private int coursor = -1;
	
	//�ж��Ƿ������һ��
	public boolean hasNext() {
		return coursor+1<size;
	}
	//��ȡ��һ��
	public String next() {
		coursor++;
		return elem[coursor];
	}
	//ɾ����һ��
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
		//���ж�,���ȡֵ
		while(list.hasNext()) {
			System.out.println(list.next());
			list.remove();
		}
		System.out.println(list.size);
	}
}
