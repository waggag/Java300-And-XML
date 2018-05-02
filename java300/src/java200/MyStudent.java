package java200;
/**
 * 1.<> -->单个大写字母,尽可能见名知意
 * 2. 	T --> Type
 * 	  	K V Key Value
 *    	E Element 
 * 3.
 * 		泛型不能使用静态属性
 * @author 王港
 * 2018年4月10日 下午5:35:15
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
