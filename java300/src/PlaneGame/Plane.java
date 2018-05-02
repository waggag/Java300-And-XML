package PlaneGame;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import cn.waggag.util.GameObject;
import cn.waggag.util.GameUtil;

public class Plane extends GameObject
{
	
	private boolean left, up, right, down;
	private boolean live = true;
	
	public void draw(Graphics g)
	{
		if(live) 
		{
			g.drawImage(img, (int)x, (int)y, null);	
			move();
		}
	}
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public Plane() {
		
	}
	//���������л�Ĭ�ϵĵ��ø���Ĺ�����
	public Plane(String path, double x, double y) 
	{
		//super();
		this.img = GameUtil.getImage(path);
		this.width = img.getWidth(null)/2;
		this.height = img.getHeight(null)/2;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * �ɻ����ƶ�
	 * @param e
	 */
	public void move()
	{
		if(left) {
			x -= speed;
		}
		if(right) {
			x += speed;
		}
		if(up) {
			y -= speed;
		}
		if(down) {
			y += speed;
		}
	}
	/**
	 * ���Ӱ˸�����
	 * @param e
	 */
	public void addDirection(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:
				left = true;
				break;
			case KeyEvent.VK_UP:
				up = true;
				break;
			case KeyEvent.VK_DOWN:
				down = true;
				break;
			case KeyEvent.VK_RIGHT:
				right = true;
				break;
			default:
				break;
		}
	}
	/**
	 * ɾ������
	 * @param e
	 */
	public void deleteDirection(KeyEvent e) 
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:
				left = false;
				break;
			case KeyEvent.VK_UP:
				up = false;
				break;
			case KeyEvent.VK_DOWN:
				down =false;
				break;
			case KeyEvent.VK_RIGHT:
				right = false;
				break;
			default:
				break;
		}
	}
}
