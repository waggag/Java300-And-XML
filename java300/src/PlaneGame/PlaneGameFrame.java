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
 * 游戏的主窗口
 * @author waggag
 * 2018年4月7日下午4:04:28
 */
@SuppressWarnings("serial")
public class PlaneGameFrame extends MyFrame{
	
	public static void main(String[] args) 
	{
		new PlaneGameFrame().lanchFrame();
	}
	
	Image bg = GameUtil.getImage("planeimages/bg.jpg");
	Plane plane = new Plane("planeimages/plane.png", 50, 50);
	
	//使用泛型,方便Bullet的取出
	ArrayList<Bullet> bulletlist = new ArrayList<Bullet>();
	
	Explode bao;
	Date startTime,liveTime,endTime;

	public void paint(Graphics g)
	{
		g.drawImage(bg, 0, 0, null);
		plane.draw(g);
		//循环打印子弹
		for(int i=0;i<bulletlist.size();i++)
		{
			Bullet b = bulletlist.get(i);
			b.draw(g);
			//检测是否与飞机发生碰撞,通过一个2个矩形的检测
			boolean peng = b.getRect().intersects(plane.getRect());
			if(!peng){
				liveTime = new Date();
			}
			
			if(plane.isLive()) {
				long period = (liveTime.getTime()-startTime.getTime())/1000;
				PrintMessage(g, "生存时间:"+period+"秒", 30, Constant.GAME_WIDTH-200, 80, Color.RED);
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
				PrintMessage(g, "存活时间:"+period+"秒", 20, Constant.GAME_WIDTH/2-100, Constant.GAME_HEIGHT/2-40, Color.RED);
				PrintMessage(g, "GAME OVER", 30,Constant.GAME_WIDTH/2-100,Constant.GAME_HEIGHT/2+50,Color.red);
				if(period>60){
					PrintMessage(g, "合    格", 30, Constant.GAME_WIDTH/2-100, Constant.GAME_HEIGHT/2, Color.red);
				}else {
					PrintMessage(g, "不合格", 30, Constant.GAME_WIDTH/2-100, Constant.GAME_HEIGHT/2, Color.red);
				}
			}
			
	}
		
	}
	/**
	 * 在窗口上打印信息
	 * @param g
	 * @param str
	 * @param size
	 */
	@Override
	public void lanchFrame() {
		super.lanchFrame();
		//增加键盘的监听
		addKeyListener(new KeyMonitor());
		//生成一堆子弹
		for(int i=0;i < 100;i++) {
			Bullet b = new Bullet();
			bulletlist.add(b);
		}
		//从游戏开始开始加载时间
		startTime = new Date();
	}

	/**
	 * 定义为内部类,可以方便使用外部类的属性
	 * @author waggag
	 * 2018年4月7日下午3:44:53
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
