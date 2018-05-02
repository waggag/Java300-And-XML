package cn.waggag.pattern.brige;
/**
 * ���ģʽ�Ľӿڶ���
 * @author waggag
 * 2018��5��2�� ����9:55:25
 */
public interface Component {
	void operation();
}

//Ҷ�����
interface Leaf extends Component{
	
}

//�������
interface Composite extends Component{
	void add(Component c);
	void remove(Component c);
	Component getChild(int index);
}