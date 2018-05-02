package cn.waggag.pattern.fiyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * ��Ԫ����
 * @author waggag
 * 2018��5��2�� ����5:18:27
 */
public class ChessFiyWeightFactory {
	//��Ԫ��
	private static Map<String, ChessFiyWeight>  map = new HashMap<>();
	
	public static ChessFiyWeight getChess(String color){
		if((map.get(color)) != null) {
			return map.get(color);
		}else {
			ChessFiyWeight cfw = new ConcreteChess(color);
			map.put(color, cfw);
			return cfw;
		}
	}
	
}
