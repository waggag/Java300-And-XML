package cn.waggag.que;

public class MyStackUsing {
	public static void main(String[] args) {
		MyStack<String>  backHiistory = new MyStack<String>(3);
		backHiistory.push("www.baidu.com");
		backHiistory.push("www.google.com");
		backHiistory.push("www.sina.com");
		//添加第四个时无法添加进去
		backHiistory.push("www.waggag.cn");
		
		System.out.println("大小："+backHiistory.size());
		
		//遍历
		String item = null;
		while(null !=(item = backHiistory.pop())) {
			System.out.println(item);
		}
	}
}
