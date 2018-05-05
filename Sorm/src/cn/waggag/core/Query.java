package cn.waggag.core;

import java.util.List;

/**
 * �����ѯ(�����ṩ����ĺ�����)
 * @author waggag
 * 2018��5��5�� ����11:32:31
 */
@SuppressWarnings("all")
public interface Query {
	/**
	 * ֱ��ִ��һ��DML���
	 * @param sql sql���
	 * @param params	����
	 * @return	ִ��sql���󷵻�Ӱ���¼������
	 */
	public int executeDML(String sql, Object[] params);
	
	/**
	 * ��һ������洢�����ݿ���
	 * @param obj  �洢�Ķ���
	 */
	public void insert(Object obj);
	
	 /**
	  *  ɾ��clazz���ж�Ӧ�ļ�¼(ָ��id)
	  * @param clazz ���Ӧ����
	  * @param id	������ֵ
	  * @return
	  */
	public int delete(Class clazz, Object id); //delete fro User where id=2;

	/**
	 * ɾ�����������ݿ��еļ�¼(�������ڵ����Ӧ����,�����ֵ��Ӧ����¼)
	 * @param obj
	 */
	public void delete(Object obj);
	
	/**
	 * ���¶�Ӧ�ļ�¼,ֻ����ָ��������
	 * @param obj 	Ҫ���µ��ֶ�
	 * @param fieldName ���µ������б�
	 * @return	Ӱ���˼���
	 */
	public int update(Object obj,String[] fieldName);// update user set uname=?,pwd=?
	
	/**
	 * ��ѯ���ض��м�¼������ÿ�м�¼��װ��clazzָ������Ķ�����
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�javabean���Class����
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public List queryRows(String sql,Class clazz,Object[] params);
	
	/**
	 * ��ѯ����һ�м�¼�������ü�¼��װ��clazzָ������Ķ�����
	 * @param sql ��ѯ���
	 * @param clazz ��װ���ݵ�javabean���Class����
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public Object queryUniqueRow(String sql,Class clazz,Object[] params);
	
	/**
	 * ��ѯ����һ��ֵ(һ��һ��)��������ֵ����
	 * @param sql ��ѯ���
	 * @param params sql�Ĳ���
	 * @return ��ѯ���Ľ��
	 */
	public Object queryValue(String sql,Object[] params);
	
	/**
	 * ��ѯ����һ������(һ��һ��)��������ֵ����
	 * @param sql ��ѯ���
	 * @param params sql�Ĳ���
	 * @return ��ѯ��������
	 */
	public Number queryNumber(String sql,Object[] params);
	
	
}
