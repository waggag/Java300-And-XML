package cn.waggag.Thread;

public class MoiveApp {
	public static void main(String[] args) {
		//共同的资源
		Moive m = new Moive();
		//多选线程
		Player p = new Player(m);
		Watcher w = new Watcher(m);
		
		new Thread(p).start();
		new Thread(w).start();
		
		
	}
}
