package cn.waggag.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class NewsApps {
	public static void main(String[] args) 
	{
		List<NewsItem> list = new ArrayList<NewsItem>();
		list.add(new NewsItem("中国登上太空",100,new Date()));
		list.add(new NewsItem("美国",50,new Date(System.currentTimeMillis()-60*60)));
		list.add(new NewsItem("王港",10,new Date(System.currentTimeMillis()+60*60)));
		System.out.println("排序前;"+list);
		//排序
		Collections.sort(list);
		System.out.println("排序后:"+list);
		
	}
}
