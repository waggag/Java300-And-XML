package cn.waggag.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义聚合类
 * @author waggag
 * 2018年5月2日 下午5:41:37
 */
public class Conrete {
	
	private List<Object> list = new ArrayList<Object>();
	
	public Conrete() {
	}
	
	public Conrete(List<Object> list) {
		super();
		this.list = list;
	}
	
	public void addObject(Object obj) {
		this.list.add(obj);
	}
	
	public void removeObject(Object obj) {
		this.list.remove(obj);
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}
	//获得正序迭代器
	public MyIterator createpositiveIterator() {
		return new ConcreteIterator();
	}
	//获得逆序迭代器
	public MyIterator createinverseIterator() {
		return new creteIterator();
	}
	//使用内部类定义Iterator
	private class ConcreteIterator implements MyIterator{
		
		private int currsor = 0;
		
		@Override
		public void first() {
			currsor = 0;
		}

		@Override
		public Object next() {
			if(currsor < list.size()) {
				return list.get(currsor++);				
			}
			return null;
		}

		@Override
		public boolean hasNext() {
			
			if(currsor < list.size()) {
				return true;
			}
			return false;
		}

		@Override
		public boolean isFirst() {
			return currsor == 0 ? true : false;
		}

		@Override
		public boolean isLast() {
			return currsor == (list.size()-1) ? true : false;
		}
		
	}
	
private class creteIterator implements MyIterator{
		
		private int currsor = list.size()-1;
		
		@Override
		public void first() {
			currsor = list.size()-1;
		}

		@Override
		public Object next() {
			if(currsor <= list.size()) {
				return list.get(currsor--);				
			}
			return null;
		}

		@Override
		public boolean hasNext() {
			
			if(currsor >= 0) {
				return true;
			}
			return false;
		}

		@Override
		public boolean isFirst() {
			return currsor == 0 ? true : false;
		}

		@Override
		public boolean isLast() {
			return currsor == (list.size()-1) ? true : false;
		}
		
	}
	
}
