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
	 * ������Ϸ����
	 */
	public void lanchFrame() 
	{
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(100, 100);
		setVisible(true);
		
		new PaintThread().start();  //�������ǵ��߳�
		
		/**
		 * ���һ���¼�������
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
	 * ����һ���ػ����ڵ��ڲ���
	 * @author waggag
	 * 2018��4��7������12:13:40
	 */
	class PaintThread extends Thread{
		/**
		 * ��ѭ�����������ϵ��ػ�����
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
	 * ����Ļ�ϴ�ӡ��Ҫ����Ϣ
	 */
	public void PrintMessage(Graphics g,String str,int size,int x,int y,Color color) 
	{
			Color c = g.getColor();
			g.setColor(color);
			Font f = new Font("����",Font.BOLD,size);
			g.setFont(f);
			g.drawString(str, x, y);
			g.setColor(c);
	}
	
	/**
	 * ����˫���弼��������Ļ����˸
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
