package cn.waggag.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 面向对象+模拟存储
 * @author 王港
 * 2018年4月11日 下午4:56:54
 */
public class MapStudent {
	public static void main(String[] args) {
		//1.考试
		List<Student> stuList = exam();
		//2.分析成绩
		Map<String, ClassRoom> map = count(stuList);
		//3.查看总分 and 平均分
		view(map);
	}
	public static void view(Map<String,ClassRoom> map)
	{
		Set<String> keys = map.keySet();
		//获取迭代器对象
		java.util.Iterator<String> keysIt = keys.iterator();
		while(keysIt.hasNext())
		{
			String no = keysIt.next();
			ClassRoom room = map.get(no);
			//查看总分,计算平均分
			double total = room.getTotal();
			double avg = total/room.getStuList().size();
			System.out.println(no+"-->"+total+"-->"+avg);
		}
	}
	
	/**
	 * 统计分析
	 * 1.面向对象
	 * 2.分拣存储
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
			
			if(room == null)  //不存在班级,创建班级
			{
				room = new ClassRoom(no);
				map.put(no, room);
			}
			//存在,放入学生
			room.getStuList().add(stu);
			room.setTotal(room.getTotal()+score);
		}
		return map;
	}
	public static List<Student> exam()
	{
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("王港","2",86));
		list.add(new Student("王","1",83));
		list.add(new Student("港","2",78));
		list.add(new Student("港王","1",89));
		list.add(new Student("港港","2",87));
		return list;
	}
	
}
