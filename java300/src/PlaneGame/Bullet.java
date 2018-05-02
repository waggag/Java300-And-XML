package PlaneGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cn.waggag.util.Constant;
import cn.waggag.util.GameObject;

public class Bullet  extends GameObject
{
	double degree;
	
	public  Rectangle getRect() 
	{
		return new Rectangle((int)x, (int)y, width, height);
	}
	
	public Bullet() 
	{
		this.x = Constant.GAME_WIDTH/2;
		this.y = Constant.GAME_HEIGHT/2;
		degree = Math.random() * Math.PI * 2;
		width = 10;
		height = 10;
		this.speed=5;
	}
	public void draw(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		
		x = x + speed * Math.cos(degree);
		y = y + speed * Math.sin(degree);
		
		/**
		 * 实测子弹碰墙反弹最佳位置
		 */
		if(y<height*3 || y>Constant.GAME_HEIGHT-width*2)
		{
			degree = -degree;
		}
		if(x<width || x>Constant.GAME_WIDTH-height*2)
		{
			degree = Math.PI-degree;
		}

		g.setColor(c);
	}
}
