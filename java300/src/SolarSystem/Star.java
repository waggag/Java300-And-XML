package SolarSystem;

import java.awt.Graphics;
import java.awt.Image;
import cn.waggag.util.GameUtil;

/**
 * ������е�����
 * @author waggag
 * 2018��4��7������12:40:29
 */
public class Star 
{
	Image img;
	double x,y;
	//ͼƬ�Ŀ�Ⱥ͸߶�,�ý�����ӵĺ���
	int width,heigth;
	
	public Star() {
	
	}
	
	public Star(Image img) 
	{
		this.img = img;
		this.width = img.getWidth(null);
		this.heigth = img.getHeight(null);
	}
	
	public Star(Image img,double x,double y) 
	{
		this(img);
		this.x = x;
		this.y = y;
	}
	
	public Star(String imgpath, double x, double y) 
	{
		this(GameUtil.getImage(imgpath), x, y);	
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(img, (int)x,(int)y,null);
	}
}
