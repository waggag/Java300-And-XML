package PlaneGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import cn.waggag.util.Constant;
import cn.waggag.util.GameUtil;
import cn.waggag.util.MyFrame;

/**
 * ��Ϸ��������
 * @author waggag
 * 2018��4��7������4:04:28
 */
@SuppressWarnings("serial")
public class PlaneGameFrame extends MyFrame{
	
	public static void main(String[] args) 
	{
		new PlaneGameFrame().lanchFrame();
	}
	
	Image bg = GameUtil.getImage("planeimages/bg.jpg");
	Plane plane = new Plane("planeimages/plane.png", 50, 50);
	
	//ʹ�÷���,����Bullet��ȡ��
	ArrayList<Bullet> bulletlist = new ArrayList<Bullet>();
	
	Explode bao;
	Date startTime,liveTime,endTime;

	public void paint(Graphics g)
	{
		g.drawImage(bg, 0, 0, null);
		plane.draw(g);
		//ѭ����ӡ�ӵ�
		for(int i=0;i<bulletlist.size();i++)
		{
			Bullet b = bulletlist.get(i);
			b.draw(g);
			//����Ƿ���ɻ�������ײ,ͨ��һ��2�����εļ��
			boolean peng = b.getRect().intersects(plane.getRect());
			if(!peng){
				liveTime = new Date();
			}
			
			if(plane.isLive()) {
				long period = (liveTime.getTime()-startTime.getTime())/1000;
				PrintMessage(g, "����ʱ��:"+period+"��", 30, Constant.GAME_WIDTH-200, 80, Color.RED);
			}
			
			if(peng) {
				plane.setLive(false);
				if(bao == null)
				{
					endTime = new Date();
					bao = new Explode(plane.x,plane.y);
					break;
				}
				bao.draw(g);
				break;
			}
			
			if(!plane.isLive())
			{
				long period = (endTime.getTime()-startTime.getTime())/1000;
				PrintMessage(g, "���ʱ��:"+period+"��", 20, Constant.GAME_WIDTH/2-100, Constant.GAME_HEIGHT/2-40, Color.RED);
				PrintMessage(g, "GAME OVER", 30,Constant.GAME_WIDTH/2-100,Constant.GAME_HEIGHT/2+50,Color.red);
				if(period>60){
					PrintMessage(g, "��    ��", 30, Constant.GAME_WIDTH/2-100, Constant.GAME_HEIGHT/2, Color.red);
				}else {
					PrintMessage(g, "���ϸ�", 30, Constant.GAME_WIDTH/2-100, Constant.GAME_HEIGHT/2, Color.red);
				}
			}
			
	}
		
	}
	/**
	 * �ڴ����ϴ�ӡ��Ϣ
	 * @param g
	 * @param str
	 * @param size
	 */
	@Override
	public void lanchFrame() {
		super.lanchFrame();
		//���Ӽ��̵ļ���
		addKeyListener(new KeyMonitor());
		//����һ���ӵ�
		for(int i=0;i < 100;i++) {
			Bullet b = new Bullet();
			bulletlist.add(b);
		}
		//����Ϸ��ʼ��ʼ����ʱ��
		startTime = new Date();
	}

	/**
	 * ����Ϊ�ڲ���,���Է���ʹ���ⲿ�������
	 * @author waggag
	 * 2018��4��7������3:44:53
	 */
	class KeyMonitor extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent arg0) {
			plane.addDirection(arg0);
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			plane.deleteDirection(arg0);
		}
	}		
}
