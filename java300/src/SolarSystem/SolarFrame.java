package SolarSystem;

import java.awt.Graphics;
import java.awt.Image;
import cn.waggag.util.Constant;
import cn.waggag.util.GameUtil;
import cn.waggag.util.MyFrame;

/**
 * 太阳系的主窗口
 * @author waggag
 * 2018年4月7日下午12:28:50
 */
@SuppressWarnings("serial")
public class SolarFrame extends MyFrame{
	Image bg = GameUtil.getImage("image/bg.jpg");
	Star sun = new Star("image/sun.jpg",Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2);
	Planet earth = new Planet("image/earth.jpg", 150, 100, 0.01, sun);
	Planet moon = new Planet(false,"image/moon.jpg", 30, 15, 0.05, earth);
	
	Planet mars = new Planet("image/Mars.jpg", 200, 130, 0.02,sun);
	
	/**
	 * 画出游戏背景
	 */
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		sun.draw(g);
		earth.draw(g);
		mars.draw(g);
		moon.draw(g);
	}
	
	public static void main(String[] args) {
		new SolarFrame().lanchFrame();
	}
}
