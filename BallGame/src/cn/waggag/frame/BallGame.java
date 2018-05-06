package cn.waggag.frame;
import java.awt.*;

@SuppressWarnings("serial")
public class BallGame extends Frame{
	
	//·�������������,Ҫע��·������
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
	 * ���Ӵ���
	 */
	void launchFream() {
		setSize(500, 300);
		setLocation(50, 50);
		setTitle("ʵ����-->������Ʒ");
		setBackground(Color.BLACK);
		setVisible(true);
		new PaintThread().start();
	}
	
	/**
	 * �ػ����ڵ��ڲ���
	 * @author waggag
	 * 2018��5��6�� ����8:11:56
	 */
	class  PaintThread extends Thread{
		public void run() {
			while(true) {
				//�ػ�����
				repaint();
				//������ͣ,1�����ػ�50��
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
