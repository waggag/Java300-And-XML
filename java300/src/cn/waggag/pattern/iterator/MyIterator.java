package cn.waggag.pattern.iterator;
/**
 * �Զ����Iterator�ӿ�
 * @author waggag
 * 2018��5��2�� ����5:39:26
 */
public interface MyIterator {
	void first();  //�α�ָ���һ��
	Object next();  //�α�ָ����һ��,�����ص�ǰԪ��
	boolean hasNext();
	
	boolean isFirst();
	boolean isLast();
	
}
