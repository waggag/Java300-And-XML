package cn.waggag.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * 游戏开发中常用的工具类（如：加载图像的方法）
 * @author wagga
 * 2018年4月6日上午1:55:36
 */
public class GameUtil 
{
	/**
	 * 工具类，方法通常为Static,构造方法通常私有
	 */
	private GameUtil() {
		
	}
	/**
	 *	给出路径,得到图片的实例
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
