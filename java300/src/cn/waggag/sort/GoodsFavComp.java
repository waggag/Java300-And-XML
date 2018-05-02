package cn.waggag.sort;
/**
 * 按收藏量排序的业务(升序)
 * @author 王港
 * 2018年4月13日 下午7:40:56
 */
public class GoodsFavComp implements java.util.Comparator<Goods>
{

		@Override
		public int compare(Goods arg0, Goods arg1) {
			return arg0.getFav()-arg1.getFav();
		}
}

