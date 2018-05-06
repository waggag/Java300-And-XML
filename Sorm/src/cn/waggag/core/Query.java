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
 * �����ѯ(�����ṩ����ĺ�����)
 * @author waggag
 * 2018��5��5�� ����11:32:31
 */
@SuppressWarnings("all")
public abstract class Query {
	/**
	 * ֱ��ִ��һ��DML���
	 * @param sql sql���
	 * @param params	����
	 * @return	ִ��sql���󷵻�Ӱ���¼������
	 */
	public int executeDML(String sql, Object[] params) 
	{
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
	
	/**
	 * ��һ������洢�����ݿ���
	 * @param obj  �洢�Ķ���
	 */
	public void insert(Object obj)
	{
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
	
	 /**
	  *  ɾ��clazz���ж�Ӧ�ļ�¼(ָ��id)
	  * @param clazz ���Ӧ����
	  * @param id	������ֵ
	  * @return
	  */
	public int delete(Class clazz, Object id) //delete fro User where id=2;
	{
		//Emp.class,2-->delete from emp where id=2
		//ͨ��Class������TableInfo
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
		//�������
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
		
		String sql = "delete from "+tableInfo.getTname()+" where "+onlyPriKey.getName()+"=? ";
		
		return executeDML(sql, new Object[]{id});
	}
	/**
	 * ɾ�����������ݿ��еļ�¼(�������ڵ����Ӧ����,�����ֵ��Ӧ����¼)
	 * @param obj
	 */
	public void delete(Object obj) 
	{
		//ͨ��Class������TableInfo
		Class c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();  //����
		
		//ͨ��������ƣ��������Զ�Ӧ��get������set����
		Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), obj);

		delete(c, priKeyValue);
	}
	
	/**
	 * ���¶�Ӧ�ļ�¼,ֻ����ָ��������
	 * @param obj 	Ҫ���µ��ֶ�
	 * @param fieldNames ���µ������б�
	 * @return	Ӱ���˼���
	 */
	public int update(Object obj,String[] fieldNames)// update user set uname=?,pwd=?
	{
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
	/**
	 * ��ѯ���ض��м�¼������ÿ�м�¼��װ��clazzָ������Ķ�����
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�javabean���Class����
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public List queryRows(String sql,Class clazz,Object[] params) 
	{
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
	
	/**
	 * ��ѯ����һ�м�¼�������ü�¼��װ��clazzָ������Ķ�����
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�javabean���Class����
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public Object queryUniqueRow(String sql,Class clazz,Object[] params)
	{
		List list = queryRows(sql, clazz, params);
		return (list==null&&list.size()>0)?null:list.get(0);
	}
	
	/**
	 * ��ѯ����һ��ֵ(һ��һ��)��������ֵ����
	 * @param sql ��ѯ���
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public Object queryValue(String sql,Object[] params) 
	{
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
	
	/**
	 * ��ѯ����һ������(һ��һ��)��������ֵ����
	 * @param sql ��ѯ���
	 * @param params sql�Ĳ���
	 * @return ��ѯ��������
	 */
	public Number queryNumber(String sql,Object[] params) 
	{
		return (Number)queryValue(sql, params);
	}
	/**
	 * 
	 * @param pageNum	�ڼ�ҳ
	 * @param size	һҳ��ʾ������
	 * @return
	 */
	public abstract Object queryPagenate(int pageNum, int size);
	
	
}
