package cn.waggag.frame;
import java.awt.*;

@SuppressWarnings("serial")
public class BallGame extends Frame{
	
	//路径出错不报告错误,要注意路径问题
	Image sun = Toolkit.getDefaultToolkit().getImage("images/sun.jpg");
	
	double x=100;
	double y=100;
	double degree = 0;
	
	public void paint(Graphics g)
	{
		g.drawImage(sun, (int)x, (int)y, null);
		x = 150 + 100 * Math.cos(degree);
		y = 150 + 100 * Math.sin(degree);
		degree = degree + 0.1;
		
		if(y>300-30){
			degree = - degree;
		}
		if(x>500-30){
			degree = 3.14-degree;
		}
		if(x<0){
			degree = 3.14-degree;
		}
		if(y<30){
			degree = -degree;
		}

	}


	/**
	 * 增加窗口
	 */
	void launchFream() {
		setSize(500, 300);
		setLocation(50, 50);
		setTitle("实验室-->王港作品");
		setBackground(Color.BLACK);
		setVisible(true);
		new PaintThread().start();
	}
	
	/**
	 * 重画窗口的内部类
	 * @author waggag
	 * 2018年5月6日 下午8:11:56
	 */
	class  PaintThread extends Thread{
		public void run() {
			while(true) {
				//重画窗口
				repaint();
				//程序暂停,1秒钟重画50次
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("It is my first java project!");
		new BallGame().launchFream();
	}
	
}
