package java100;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * ���ӻ�����������,û�гɹ�
 * @author ����
 *
 */
public class VisualCalender {
	
	public static void main(String[] args) {
		String temp = "2018-4-4";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = df.parse(temp);
			Calendar calender = new GregorianCalendar();
			calender.setTime(date);
			
			calender.set(Calendar.DATE, 1);
			System.out.println(calender.getFirstDayOfWeek());
			System.out.println("��\tһ\t��\t��\t��\t��\t��");
			int j=0;
			for(int i=1;i<=31;i++)
			{
				System.out.print(i+"\t");
				j++;
				if(j%7==0)
				{
					System.out.println();
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		
	}

}
