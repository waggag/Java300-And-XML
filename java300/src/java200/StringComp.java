package java200;

public class StringComp implements java.util.Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		int len1 = arg0.length();
		int len2 = arg1.length();
		return len1-len2;
	}
	
}
