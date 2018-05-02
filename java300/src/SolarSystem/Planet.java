package SolarSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import cn.waggag.util.GameUtil;
/**
 * ������ǵ���,�̳���Star
 * @author waggag
 * 2018��4��7������1:03:56
 */
public class Planet extends Star {
	
	/**
	 * ����ͼƬ������,��������һ����Բ����: �ٶ�,�Ƕ�,����һ��Star���� 
	 */
	double longAxis;	 // ����
	double shortAxis;  	// ����
	double speed;   	// ���е��ٶ�
	double degree;		// �Ƕ�
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
	//������Բ����ۼ�
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
	//������Բ�켣�ƶ�
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
	
	//���õĹ��췽��
	public Planet(Image img, double x, double y) 
	{
		super(img, x, y);
	}

	public Planet(String imgpath, double x, double y) 
	{
		super(imgpath, x, y);
	}
		
}
