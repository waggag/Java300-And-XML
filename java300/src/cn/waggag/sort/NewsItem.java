package cn.waggag.sort;

import java.util.Date;

/**
 * ������Ŀ��ʵ����
 * @author ����
 * 2018��4��11�� ����8:39:54
 */
public class NewsItem implements java.lang.Comparable<NewsItem>{
	private String title;
	private int hite;
	private Date pubtime;

	public NewsItem(String title, int hite, Date pubtime) {
		super();
		this.title = title;
		this.hite = hite;
		this.pubtime = pubtime;
	}
	public NewsItem() {
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHite() {
		return hite;
	}
	public void setHite(int hite) {
		this.hite = hite;
	}
	public Date getPubtime() {
		return pubtime;
	}
	public void setPubtime(Date pubtime) {
		this.pubtime = pubtime;
	}
	
	//ʱ�併��,���������,��������
	@Override
	public int compareTo(NewsItem arg0) {
		int result = 0;
		result = this.pubtime.compareTo(arg0.pubtime);
		if(result == 0) {
			//ʱ����ͬ
			result = this.hite-arg0.hite;
			if(result == 0) {
				result = this.title.compareTo(arg0.title);
			}
		}
		return result;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("����  ").append(this.title);
		sb.append("�����  ").append(this.hite);
		return sb.toString();
	}
	
}
