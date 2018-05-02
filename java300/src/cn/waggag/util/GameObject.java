package cn.waggag.util;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	protected Image img;
	public double x;
	public double y;
	protected int speed=5;
	protected int width, height;

	public GameObject(Image img, double x, double y, int speed, int width, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	
	public GameObject() {
		super();
	}

	public  Rectangle getRect() 
	{
		return new Rectangle((int)x, (int)y, width, height);
	}
}
