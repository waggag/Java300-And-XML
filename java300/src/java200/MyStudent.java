package java200;
/**
 * 1.<> -->������д��ĸ,�����ܼ���֪��
 * 2. 	T --> Type
 * 	  	K V Key Value
 *    	E Element 
 * 3.
 * 		���Ͳ���ʹ�þ�̬����
 * @author ����
 * 2018��4��10�� ����5:35:15
 */
public class MyStudent<T> {
	private T javase;

	public T getJavase() {
		return javase;
	}

	public void setJavase(T javase) {
		this.javase = javase;
	}

	/**
	 * @param javase
	 */
	public MyStudent(T javase) {
		super();
		this.javase = javase;
	}
	
	public MyStudent() {
		
	}
}
