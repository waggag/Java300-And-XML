package cn.waggag.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsApp {
	public static void main(String[] args) {
		List<Goods> list = new ArrayList<Goods>();
		list.add(new Goods("����", 100, 2000));
		list.add(new Goods("��", 20, 200));
		list.add(new Goods("��", 1000, 1000));
		System.out.println("����ǰ"+list);
		//���ݼ۸��������
		//Collections.sort(list,new GoodsPriceComp());
		//�����ղ�����������
		Collections.sort(list,new GoodsFavComp());
		System.out.println("�����"+list);
	}
}
