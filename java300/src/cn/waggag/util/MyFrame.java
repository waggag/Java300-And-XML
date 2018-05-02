package cn.waggag.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


@SuppressWarnings("serial")
public class MyFrame extends Frame {
	/**
	 * 加载游戏窗口
	 */
	public void lanchFrame() 
	{
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(100, 100);
		setVisible(true);
		
		new PaintThread().start();  //启动我们的线程
		
		/**
		 * 添加一个事件监听器
		 */
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				
			}
			
		
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
					
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
			}
		});
	}
	
	/**
	 * 定义一个重画窗口的内部类
	 * @author waggag
	 * 2018年4月7日下午12:13:40
	 */
	class PaintThread extends Thread{
		/**
		 * 死循环，用来不断的重画方法
		 */
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 在屏幕上打印需要的消息
	 */
	public void PrintMessage(Graphics g,String str,int size,int x,int y,Color color) 
	{
			Color c = g.getColor();
			g.setColor(color);
			Font f = new Font("宋体",Font.BOLD,size);
			g.setFont(f);
			g.drawString(str, x, y);
			g.setColor(c);
	}
	
	/**
	 * 利用双缓冲技术消除屏幕的闪烁
	 */
	private Image offScreenImage = null;
	public void update(Graphics g)
	{
		if(offScreenImage == null)
		{
			offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		}
		Graphics goff = offScreenImage.getGraphics();
		paint(goff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
}
