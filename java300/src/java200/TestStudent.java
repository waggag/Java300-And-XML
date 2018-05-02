package java200;
/**
 * 自定义泛型类在使用时,声明具体的类型不能为基本数据类型
 * @author 王港
 * 2018年4月10日 下午5:38:21
 */
public class TestStudent {
	public static void main(String[] args) {
		MyStudent<Integer> stu = new MyStudent<Integer>();
		stu.setJavase(80);
		Integer score = stu.getJavase();
		System.out.println(score);
	}
}
