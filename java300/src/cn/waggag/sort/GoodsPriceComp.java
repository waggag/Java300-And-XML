package cn.waggag.sort;

/**
 * 按价格排序的业务(降序)
 * @author 王港
 * 2018年4月13日 下午7:40:56
 */
public class GoodsPriceComp implements java.util.Comparator<Goods>{

	@Override
	public int compare(Goods arg0, Goods arg1) {
		return -(arg0.getPrice()-arg1.getPrice() > 0 ? 1 : (arg0.getPrice()==arg1.getPrice()) ? 0 : -1) ;
	}
	
	
}
