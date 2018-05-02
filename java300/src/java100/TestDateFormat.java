package java100;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
	
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Date d = new Date(231263);
		String str = df.format(d);
		System.out.println(str);
	}
}
