package cn.waggag.sort;

/**
 * ���۸������ҵ��(����)
 * @author ����
 * 2018��4��13�� ����7:40:56
 */
public class GoodsPriceComp implements java.util.Comparator<Goods>{

	@Override
	public int compare(Goods arg0, Goods arg1) {
		return -(arg0.getPrice()-arg1.getPrice() > 0 ? 1 : (arg0.getPrice()==arg1.getPrice()) ? 0 : -1) ;
	}
	
	
}
