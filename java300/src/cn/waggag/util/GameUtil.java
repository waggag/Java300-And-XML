package cn.waggag.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * ��Ϸ�����г��õĹ����ࣨ�磺����ͼ��ķ�����
 * @author wagga
 * 2018��4��6������1:55:36
 */
public class GameUtil 
{
	/**
	 * �����࣬����ͨ��ΪStatic,���췽��ͨ��˽��
	 */
	private GameUtil() {
		
	}
	/**
	 *	����·��,�õ�ͼƬ��ʵ��
	 * @param path  image path
	 * @return return a image 
	 */
	public static Image getImage(String path)
	{
		URL url = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
