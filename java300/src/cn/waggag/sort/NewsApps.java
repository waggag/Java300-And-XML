package cn.waggag.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class NewsApps {
	public static void main(String[] args) 
	{
		List<NewsItem> list = new ArrayList<NewsItem>();
		list.add(new NewsItem("�й�����̫��",100,new Date()));
		list.add(new NewsItem("����",50,new Date(System.currentTimeMillis()-60*60)));
		list.add(new NewsItem("����",10,new Date(System.currentTimeMillis()+60*60)));
		System.out.println("����ǰ;"+list);
		//����
		Collections.sort(list);
		System.out.println("�����:"+list);
		
	}
}
