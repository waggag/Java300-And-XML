package cn.waggag.pattern.brige;
/**
 * 组合模式的接口定义
 * @author waggag
 * 2018年5月2日 上午9:55:25
 */
public interface Component {
	void operation();
}

//叶子组件
interface Leaf extends Component{
	
}

//容器组件
interface Composite extends Component{
	void add(Component c);
	void remove(Component c);
	Component getChild(int index);
}