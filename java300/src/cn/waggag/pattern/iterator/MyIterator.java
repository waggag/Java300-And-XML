package cn.waggag.pattern.iterator;
/**
 * 自定义的Iterator接口
 * @author waggag
 * 2018年5月2日 下午5:39:26
 */
public interface MyIterator {
	void first();  //游标指向第一个
	Object next();  //游标指向下一个,并返回当前元素
	boolean hasNext();
	
	boolean isFirst();
	boolean isLast();
	
}
