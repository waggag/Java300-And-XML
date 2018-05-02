package PlaneGame;

import java.awt.Graphics;
import java.awt.Image;

import cn.waggag.util.GameUtil;

public  class Explode {
	double x,y;
	int count=0;
	static Image[] imgs = new Image[16];
	
	//静态块,用于对静态变量的操作
	static 
	{
		for(int i=0;i<16;i++)
		{
			imgs[i] = GameUtil.getImage("planeimages/e"+(i+1)+".gif");
			imgs[i].getWidth(null);
		}
	}
	
	public void draw(Graphics g)
	{
		if(count<=15) {
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
		}
		
	}
	public Explode(double x,double y)
	{
		this.x = x;
		this.y = y;
	}
}
