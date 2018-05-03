package cn.waggag.pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责人类,负责管理备忘录对象
 * @author waggag
 * 2018年5月3日 上午7:51:35
 */
@SuppressWarnings("all")
public class CareTaker {
	
	private EmpMemento memento;
	
	private List<EmpMemento> list = new ArrayList<EmpMemento>();

	public EmpMemento getMemento() {
		return memento;
	}

	public void setMemento(EmpMemento memento) {
		this.memento = memento;
	}
}
