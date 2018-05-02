package cn.waggag.pattern.brige;
/**
 * 测试多继承模式
 * @author waggag
 * 2018年5月2日 上午9:48:16
 */
public class Client {
	
	public static void main(String[] args) {
		//销售联想的笔记本
		Computer c = new DeskTop(new Leveno());
		c.sale();
		
		//销售Dell的笔记本
		Computer c2 = new LapTop(new Dell());
		c2.sale();
	}
}
