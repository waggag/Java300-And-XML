package cn.waggag.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import cn.waggag.bean.ColumnInfo;
import cn.waggag.bean.TableInfo;
import cn.waggag.utils.JDBCUtils;
import cn.waggag.utils.ReflectUtils;

/**
 * 负责查询(对外提供服务的核心类)
 * @author waggag
 * 2018年5月5日 上午11:32:31
 */
@SuppressWarnings("all")
public abstract class Query {
	/**
	 * 直接执行一个DML语句
	 * @param sql sql语句
	 * @param params	参数
	 * @return	执行sql语句后返回影响记录的行数
	 */
	public int executeDML(String sql, Object[] params) 
	{
		Connection con = DBManager.getConnection();
		int count = 0; 
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			
			//给sql设参
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
	
	/**
	 * 将一个对象存储到数据库中
	 * @param obj  存储的对象
	 */
	public void insert(Object obj)
	{
		//obj-->表中。             insert into 表名  (id,uname,pwd) values (?,?,?)
		Class c = obj.getClass();
		
		//存储sql的参数对象
		List<Object> params = new ArrayList<Object>();   
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		StringBuilder sql  = new StringBuilder("insert into "+tableInfo.getTname()+" (");
	
		//计算不为null的属性值
		int countNotNullField = 0;   
	
		//获得所有的属性
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
	
	 /**
	  *  删除clazz表中对应的记录(指定id)
	  * @param clazz 表对应的类
	  * @param id	主键的值
	  * @return
	  */
	public int delete(Class clazz, Object id) //delete fro User where id=2;
	{
		//Emp.class,2-->delete from emp where id=2
		//通过Class对象找TableInfo
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
		//获得主键
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
		
		String sql = "delete from "+tableInfo.getTname()+" where "+onlyPriKey.getName()+"=? ";
		
		return executeDML(sql, new Object[]{id});
	}
	/**
	 * 删除对象在数据库中的记录(对象所在的类对应到表,对象的值对应到记录)
	 * @param obj
	 */
	public void delete(Object obj) 
	{
		//通过Class对象找TableInfo
		Class c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();  //主键
		
		//通过反射机制，调用属性对应的get方法或set方法
		Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), obj);

		delete(c, priKeyValue);
	}
	
	/**
	 * 更新对应的记录,只更新指定的属性
	 * @param obj 	要更新的字段
	 * @param fieldNames 更新的属性列表
	 * @return	影响了几行
	 */
	public int update(Object obj,String[] fieldNames)// update user set uname=?,pwd=?
	{
		//obj{"uanme","pwd"}-->update 表名  set uname=?,pwd=? where id=?
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>();   //存储sql的参数对象的值
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		
		//获得唯一的主键
		ColumnInfo  priKey = tableInfo.getOnlyPriKey();   
		
		StringBuilder sql  = new StringBuilder("update "+tableInfo.getTname()+" set ");
		
		for(String fname:fieldNames){
			Object fvalue = ReflectUtils.invokeGet(fname,obj);
			//fvalue是每个记录对应的值
			params.add(fvalue);
			sql.append(fname+"=?,");
		}
		sql.setCharAt(sql.length()-1, ' ');
		sql.append(" where ");
		sql.append(priKey.getName()+"=? ");
		
		params.add(ReflectUtils.invokeGet(priKey.getName(), obj));    //主键的值
		
		return executeDML(sql.toString(), params.toArray()); 
	}
	/**
	 * 查询返回多行记录，并将每行记录封装到clazz指定的类的对象中
	 * @param sql 查询语句
	 * @param clazz 封装数据的javabean类的Class对象
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public List queryRows(String sql,Class clazz,Object[] params) 
	{
		Connection conn = DBManager.getConnection();
		List list = null;    //存储查询结果的容器
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			//给sql设参
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			//多行
			while(rs.next()){
				
				if(list==null){
					list = new ArrayList();
				}
				Object rowObj = clazz.newInstance();   //调用javabean的无参构造器
				
				//多列       select username ,pwd,age from user where id>? and age>18
				for(int i=0;i<metaData.getColumnCount();i++){
					String columnName = metaData.getColumnLabel(i+1);  //username
					Object columnValue = rs.getObject(i+1);
					
					//调用rowObj对象的setUsername(String uname)方法，将columnValue的值设置进去
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
	
	/**
	 * 查询返回一行记录，并将该记录封装到clazz指定的类的对象中
	 * @param sql 查询语句
	 * @param clazz 封装数据的javabean类的Class对象
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public Object queryUniqueRow(String sql,Class clazz,Object[] params)
	{
		List list = queryRows(sql, clazz, params);
		return (list==null&&list.size()>0)?null:list.get(0);
	}
	
	/**
	 * 查询返回一个值(一行一列)，并将该值返回
	 * @param sql 查询语句
	 * @param params sql的参数
	 * @return 查询到的结果
	 */
	public Object queryValue(String sql,Object[] params) 
	{
		Connection conn = DBManager.getConnection();
		Object value = null;    //存储查询结果的对象
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			//给sql设参
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
	
	/**
	 * 查询返回一个数字(一行一列)，并将该值返回
	 * @param sql 查询语句
	 * @param params sql的参数
	 * @return 查询到的数字
	 */
	public Number queryNumber(String sql,Object[] params) 
	{
		return (Number)queryValue(sql, params);
	}
	/**
	 * 
	 * @param pageNum	第几页
	 * @param size	一页显示的数量
	 * @return
	 */
	public abstract Object queryPagenate(int pageNum, int size);
	
	
}
