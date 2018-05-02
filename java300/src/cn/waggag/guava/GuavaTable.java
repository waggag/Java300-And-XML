package cn.waggag.guava;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.Tables;

/**
 * 双键的Map -->table -->rowKey + columnKey
 * 
 * @author wagga
 * 2018年4月14日下午6:13:21
 */
public class GuavaTable {

	public static void main(String[] args) {
		Table<String, String, Integer> tables = HashBasedTable.create();
		//测试数据
		tables.put("a", "javase", 80);
		tables.put("b", "javase", 90);
		tables.put("a", "oracle", 100);
		tables.put("b", "oracle", 95);
		
		//查看所有的行数据
		Set<Cell<String, String, Integer>> cells = tables.cellSet();
		for(Cell<String, String, Integer> temp: cells) {
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
		System.out.println("===========按学生查看成绩===============");
		System.out.print("学生\t");
		//所有的课程
		Set<String> cours = tables.columnKeySet();
		for(String temp: cours) {
			System.out.print(temp+"\t");
		}
		System.out.println();
		//所有的学生
		Set<String> stus = tables.rowKeySet();
		for(String temp: stus) {
			
			System.out.print(temp+"\t");
			
			Map<String, Integer> scores = tables.row(temp);
			for(String c: cours) {
				System.out.print(scores.get(c)+"\t");
			}
			
			System.out.println();
		}
		
		System.out.println("===========按课程查看成绩===============");
		System.out.print("课程\t");
		//所有的学生
		Set<String> stus1 = tables.rowKeySet();
		for(String temp: stus1) {
			System.out.print(temp+"\t");
		}
		System.out.println();
		//所有的课程
		Set<String> course = tables.columnKeySet();
		for(String temp: course) {
			
			System.out.print(temp+"\t");
			
			Map<String, Integer> scores = tables.column(temp);
			for(String c: stus1) {
				System.out.print(scores.get(c)+"\t");
			}
			System.out.println();
		}
		
		System.out.println("============转换=============");
		
		Table<String, String, Integer> tables2 = Tables.transpose(tables);
		//查看所有的行数据
		Set<Cell<String, String, Integer>> cells2 = tables2.cellSet();
		for(Cell<String, String, Integer> temp: cells2) {
			System.out.println(temp.getRowKey()+"-->"+temp.getColumnKey()+"-->"+temp.getValue());
		}
		
	}

}
