package cn.waggag.pattern.state;
/**
 * 空闲状态
 * @author waggag
 * 2018年5月2日 下午8:50:34
 */
public class CheckState implements State{

	@Override
	public void hander() {
		System.out.println("房间预定");
	}
	
}
