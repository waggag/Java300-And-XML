package cn.waggag.core;

import java.util.List;

/**
 * 负责针对mysql数据库的查询
 * @author waggag
 * 2018年5月5日 下午8:06:51
 */
@SuppressWarnings("all")
public class MySqlQuery extends Query{

	public static void testDML(){
//		Emp e = new Emp();
//		e.setEmpname("lily");
//		e.setBirthday(new java.sql.Date(System.currentTimeMillis()));
//		e.setAge(30);
//		e.setSalary(3000.8);
//		e.setId(3);
//		new MySqlQuery().delete(e);
//		new MySqlQuery().insert(e);
		//new MySqlQuery().update(e,new String[]{"empname","age","salary"});
	}
	
	public static void testQueryRows(){
		
//		List<Emp> list = new MySqlQuery().queryRows("select id,empname,age from emp where age>? and salary<?",
//				Emp.class, new Object[]{10,5000});
//		for(Emp e:list){
//			System.out.println(e.getEmpname());
//		}
		
		String sql2 = "select e.id,e.empname,age,d.dname 'deptName',d.address 'deptAddr' from emp e "
				+"join dept d on e.id=d.id ";
		List<EmpVo> list2 = new MySqlQuery().queryRows(sql2,
				EmpVo.class, null);
		
		for(EmpVo e:list2){
			System.out.println(e.getId()+"-"+e.getEmpname()+"-"+e.getDeptAddr());
		}
		
	}
	
	public static void main(String[] args) {
		Number obj = (Number)new MySqlQuery().queryValue("select count(*) from emp where salary>?",new Object[]{1000});
//		//Number obj = new MySqlQuery().queryNumber("select count(*) from emp where salary>?",new Object[]{1000});
		System.out.println(obj.doubleValue());
//		
//		testDML();
//		testQueryRows();
	}

	@Override
	public Object queryPagenate(int pageNum, int size) {
		return null;
	}


}
