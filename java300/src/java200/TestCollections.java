package java200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用Collections的常用方法
 * 1.洗牌,模拟斗地主
 * @author 王港
 * 2018年4月13日 下午9:03:53
 */
public class TestCollections {
	
		public static void main(String[] args) {
			List<Integer>  list = new ArrayList<Integer>();
			//shuffle 洗牌,模拟斗地主
			for(int i=0;i < 54;i++)
			{
				list.add(i);
			}
			//洗牌
			Collections.shuffle(list);
			//依次发牌
			List<Integer> p1 = new ArrayList<Integer>();
			List<Integer> p2 = new ArrayList<Integer>();
			List<Integer> p3 = new ArrayList<Integer>();
			List<Integer> last = new ArrayList<Integer>();
			for(int i=0;i<54;i+=3)
			{
				p1.add(list.get(i));
				p2.add(list.get(i+1));
				p3.add(list.get(i+2));
			}
			//最后三张为底牌
			last.add(list.get(51));
			last.add(list.get(52));
			last.add(list.get(53));
			//输出三个人的各种牌
			System.out.println("第一个人:"+p1);
			System.out.println("第二个人:"+p2);
			System.out.println("第三个人:"+p3);
			System.out.println("底牌:"+last);
		}
}
