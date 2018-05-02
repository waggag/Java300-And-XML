package cn.waggag.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * �������+ģ��洢
 * @author ����
 * 2018��4��11�� ����4:56:54
 */
public class MapStudent {
	public static void main(String[] args) {
		//1.����
		List<Student> stuList = exam();
		//2.�����ɼ�
		Map<String, ClassRoom> map = count(stuList);
		//3.�鿴�ܷ� and ƽ����
		view(map);
	}
	public static void view(Map<String,ClassRoom> map)
	{
		Set<String> keys = map.keySet();
		//��ȡ����������
		java.util.Iterator<String> keysIt = keys.iterator();
		while(keysIt.hasNext())
		{
			String no = keysIt.next();
			ClassRoom room = map.get(no);
			//�鿴�ܷ�,����ƽ����
			double total = room.getTotal();
			double avg = total/room.getStuList().size();
			System.out.println(no+"-->"+total+"-->"+avg);
		}
	}
	
	/**
	 * ͳ�Ʒ���
	 * 1.�������
	 * 2.�ּ�洢
	 * @return
	 */
	public static Map<String,ClassRoom> count(List<Student> list)
	{
		Map<String,ClassRoom> map = new HashMap<String,ClassRoom>();
		for(Student stu: list) 
		{
			String no = stu.getNo();
			double score = stu.getScore();
			ClassRoom room = map.get(no);
			
			if(room == null)  //�����ڰ༶,�����༶
			{
				room = new ClassRoom(no);
				map.put(no, room);
			}
			//����,����ѧ��
			room.getStuList().add(stu);
			room.setTotal(room.getTotal()+score);
		}
		return map;
	}
	public static List<Student> exam()
	{
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("����","2",86));
		list.add(new Student("��","1",83));
		list.add(new Student("��","2",78));
		list.add(new Student("����","1",89));
		list.add(new Student("�۸�","2",87));
		return list;
	}
	
}
