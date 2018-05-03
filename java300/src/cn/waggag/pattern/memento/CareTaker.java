package cn.waggag.pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������,���������¼����
 * @author waggag
 * 2018��5��3�� ����7:51:35
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
