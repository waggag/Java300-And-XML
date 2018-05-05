package cn.waggag.core;
/**
 * ����java�������͵Ķ�̬ת��
 * @author waggag
 * 2018��5��5�� ����12:11:45
 */
public interface TypeConvertor {
	
	/**
	 * �����ݿ���������ת����java����������
	 * @param columnType ���ݿ��ֶε���������
	 * @return java����������
	 */
	public String databaseType2JavaType(String columnType);
	
	/**
	 * ��java��������ת�������ݿ���������
	 * @param javaDataType java��������
	 * @return ���ݿ�����
	 */
	public String javaType2DatabaseType(String javaDataType);
	
}
