package cn.waggag.sort;
/**
 * ���ղ��������ҵ��(����)
 * @author ����
 * 2018��4��13�� ����7:40:56
 */
public class GoodsFavComp implements java.util.Comparator<Goods>
{

		@Override
		public int compare(Goods arg0, Goods arg1) {
			return arg0.getFav()-arg1.getFav();
		}
}

