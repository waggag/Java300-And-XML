package cn.waggag.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsApp {
	public static void main(String[] args) {
		List<Goods> list = new ArrayList<Goods>();
		list.add(new Goods("王港", 100, 2000));
		list.add(new Goods("王", 20, 200));
		list.add(new Goods("孟", 1000, 1000));
		System.out.println("排序前"+list);
		//根据价格进行排序
		//Collections.sort(list,new GoodsPriceComp());
		//根据收藏量升序排序
		Collections.sort(list,new GoodsFavComp());
		System.out.println("排序后"+list);
	}
}
