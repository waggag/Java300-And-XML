package cn.waggag.que;

public class MyStackUsing {
	public static void main(String[] args) {
		MyStack<String>  backHiistory = new MyStack<String>(3);
		backHiistory.push("www.baidu.com");
		backHiistory.push("www.google.com");
		backHiistory.push("www.sina.com");
		//��ӵ��ĸ�ʱ�޷���ӽ�ȥ
		backHiistory.push("www.waggag.cn");
		
		System.out.println("��С��"+backHiistory.size());
		
		//����
		String item = null;
		while(null !=(item = backHiistory.pop())) {
			System.out.println(item);
		}
	}
}
