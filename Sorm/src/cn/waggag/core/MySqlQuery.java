package cn.waggag.core;

import java.util.List;

import cn.waggag.bean.ColumnInfo;
import cn.waggag.bean.TableInfo;
import cn.waggag.po.Emp;
import cn.waggag.utils.JDBCUtils;
import cn.waggag.utils.ReflectUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * �������mysql���ݿ�Ĳ�ѯ
 * @author waggag
 * 2018��5��5�� ����8:06:51
 */
@SuppressWarnings("all")
public class MySqlQuery implements Query{

	public static void testDML(){
		Emp e = new Emp();
//		e.setEmpname("lily");
//		e.setBirthday(new java.sql.Date(System.currentTimeMillis()));
//		e.setAge(30);
//		e.setSalary(3000.8);
		e.setId(3);
		new MySqlQuery().delete(e);
//		new MySqlQuery().insert(e);
		//new MySqlQuery().update(e,new String[]{"empname","age","salary"});
	}
	
	public static void testQueryRows(){
		List<Emp> list = new MySqlQuery().queryRows("select id,empname,age from emp where age>? and salary<?",
				Emp.class, new Object[]{10,5000});
		
		for(Emp e:list){
			System.out.println(e.getEmpname());
		}
		
		String sql2 = "select e.id,e.empname,salary+bonus 'xinshui',age,d.dname 'deptName',d.address 'deptAddr' from emp e "
				+"join dept d on e.deptId=d.id ";
//		List<EmpVO> list2 = new MySqlQuery().queryRows(sql2,
//				EmpVO.class, null);
//		
//		for(EmpVO e:list2){
//			System.out.println(e.getEmpname()+"-"+e.getDeptAddr()+"-"+e.getXinshui());
//		}
		
	}
	
	
	public static void main(String[] args) {
		Number obj = (Number)new MySqlQuery().queryValue("select count(*) from emp where salary>?",new Object[]{1000});
		//Number obj = new MySqlQuery().queryNumber("select count(*) from emp where salary>?",new Object[]{1000});
		System.out.println(obj.doubleValue());
		
		testDML();
	}
	
	@Override
	public int delete(Class clazz, Object id) {
		//Emp.class,2-->delete from emp where id=2
		//ͨ��Class������TableInfo
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
		//�������
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
		
		String sql = "delete from "+tableInfo.getTname()+" where "+onlyPriKey.getName()+"=? ";
		
		return executeDML(sql, new Object[]{id});
	}

	@Override
	public void delete(Object obj) {
		//ͨ��Class������TableInfo
		Class c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();  //����
		
		//ͨ��������ƣ��������Զ�Ӧ��get������set����
		Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), obj);

		delete(c, priKeyValue);
	}

	@Override
	public int executeDML(String sql, Object[] params) {
		Connection con = DBManager.getConnection();
		int count = 0; 
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			
			//��sql���
			JDBCUtils.handleParams(ps, params);
			
			System.out.println(ps);
			count  = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		
		return count;
	}

	@Override
	public void insert(Object obj) {
		//obj-->���С�             insert into ����  (id,uname,pwd) values (?,?,?)
		Class c = obj.getClass();
		
		//�洢sql�Ĳ�������
		List<Object> params = new ArrayList<Object>();   
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		StringBuilder sql  = new StringBuilder("insert into "+tableInfo.getTname()+" (");
	
		//���㲻Ϊnull������ֵ
		int countNotNullField = 0;   
	
		//������е�����
		Field[] fs = c.getDeclaredFields();
		for(Field f:fs){
			String fieldName = f.getName();
			Object fieldValue = ReflectUtils.invokeGet(fieldName, obj);
			
			if(fieldValue!=null){
				countNotNullField++;
				sql.append(fieldName+",");
				params.add(fieldValue);
			}
		}
		
		sql.setCharAt(sql.length()-1, ')');
		sql.append(" values (");
		for(int i=0;i<countNotNullField;i++){
			sql.append("?,");
		}
		sql.setCharAt(sql.length()-1, ')');
		
		executeDML(sql.toString(), params.toArray());
	}

	@Override
	public Number queryNumber(String sql, Object[] params) {
		return (Number)queryValue(sql, params);
	}

	@Override
	public List queryRows(String sql, Class clazz, Object[] params) {

		Connection conn = DBManager.getConnection();
		List list = null;    //�洢��ѯ���������
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			//��sql���
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			//����
			while(rs.next()){
				
				if(list==null){
					list = new ArrayList();
				}
				Object rowObj = clazz.newInstance();   //����javabean���޲ι�����
				
				//����       select username ,pwd,age from user where id>? and age>18
				for(int i=0;i<metaData.getColumnCount();i++){
					String columnName = metaData.getColumnLabel(i+1);  //username
					Object columnValue = rs.getObject(i+1);
					
					//����rowObj�����setUsername(String uname)��������columnValue��ֵ���ý�ȥ
					ReflectUtils.invokeSet(rowObj, columnName, columnValue);
				}
				
				list.add(rowObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(ps, conn);
		}
	
		return list;
	}

	@Override
	public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
		List list = queryRows(sql, clazz, params);
		return (list==null&&list.size()>0)?null:list.get(0);
	}

	@Override
	public Object queryValue(String sql, Object[] params) {
		Connection conn = DBManager.getConnection();
		Object value = null;    //�洢��ѯ����Ķ���
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			//��sql���
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			rs = ps.executeQuery();
			while(rs.next()){
				value = rs.getObject(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(ps, conn);
		}
	
		return value;
	
	}

	@Override
	public int update(Object obj, String[] fieldNames) {
		//obj{"uanme","pwd"}-->update ����  set uname=?,pwd=? where id=?
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>();   //�洢sql�Ĳ��������ֵ
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		
		//���Ψһ������
		ColumnInfo  priKey = tableInfo.getOnlyPriKey();   
		
		StringBuilder sql  = new StringBuilder("update "+tableInfo.getTname()+" set ");
		
		for(String fname:fieldNames){
			Object fvalue = ReflectUtils.invokeGet(fname,obj);
			//fvalue��ÿ����¼��Ӧ��ֵ
			params.add(fvalue);
			sql.append(fname+"=?,");
		}
		sql.setCharAt(sql.length()-1, ' ');
		sql.append(" where ");
		sql.append(priKey.getName()+"=? ");
		
		params.add(ReflectUtils.invokeGet(priKey.getName(), obj));    //������ֵ
		
		return executeDML(sql.toString(), params.toArray()); 
	}
}
