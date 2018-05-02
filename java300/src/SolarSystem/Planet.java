package SolarSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import cn.waggag.util.GameUtil;
/**
 * 绘出行星的类,继承自Star
 * @author waggag
 * 2018年4月7日下午1:03:56
 */
public class Planet extends Star {
	
	/**
	 * 除了图片和坐标,行星沿着一个椭圆运行: 速度,角度,绕着一个Star飞行 
	 */
	double longAxis;	 // 长轴
	double shortAxis;  	// 短轴
	double speed;   	// 飞行的速度
	double degree;		// 角度
	Star center ;
	boolean satellite = true;
	
	
	@Override
	public void draw(Graphics g) 
	{
		super.draw(g);
		if(satellite) {
			drawTrace(g);
		}
		move();
	}
	//画出椭圆轨道痕迹
	public void drawTrace(Graphics g)
	{
		double  OvalX,OvalY,OvalWigth,OvalHeigth;
		OvalWigth = longAxis * 2;
		OvalHeigth = shortAxis * 2;
		OvalX = center.x + center.width/2 - longAxis;
		OvalY = center.y + center.heigth/2 -shortAxis;
		
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)OvalX, (int)OvalY, (int)OvalWigth, (int)OvalHeigth);
		g.setColor(c);
	}
	//沿着椭圆轨迹移动
	public void move()
	{
		x = center.x + center.width/2 + longAxis*Math.cos(degree);
		y = center.y + center.heigth/2 + shortAxis*Math.sin(degree);
		
		degree = degree + speed;
	}

	public Planet(String imgpath, double longAxis, double shortAxis, double speed, Star center) 
	{
		super(GameUtil.getImage(imgpath));
		
		this.center = center;
		this.x = center.x + longAxis;
		this.y = center.y;
		
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
	}
	
	public Planet(boolean satellite, String imgpath, double longAxis, double shortAxis, double speed, Star center) 
	{
		this(imgpath, longAxis, shortAxis, speed, center);
		this.satellite = satellite;
	}
	
	//无用的构造方法
	public Planet(Image img, double x, double y) 
	{
		super(img, x, y);
	}

	public Planet(String imgpath, double x, double y) 
	{
		super(imgpath, x, y);
	}
		
}
