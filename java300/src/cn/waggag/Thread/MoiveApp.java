package cn.waggag.Thread;

public class MoiveApp {
	public static void main(String[] args) {
		//��ͬ����Դ
		Moive m = new Moive();
		//��ѡ�߳�
		Player p = new Player(m);
		Watcher w = new Watcher(m);
		
		new Thread(p).start();
		new Thread(w).start();
		
		
	}
}
