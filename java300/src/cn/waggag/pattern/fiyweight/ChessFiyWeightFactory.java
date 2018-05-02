package cn.waggag.pattern.fiyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 * @author waggag
 * 2018年5月2日 下午5:18:27
 */
public class ChessFiyWeightFactory {
	//享元池
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
