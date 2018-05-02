package java100;

public class TestString {
	public static void main(String[] args) {
		String s=new String("ab,cd,fg");
		String[] str = s.split(",");
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i]);
		}
	}
}
