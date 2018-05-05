package cn.waggag.bean;
/**
 * ��װ��java���Ժ�get,set������Դ����
 * @author waggag
 * 2018��5��5�� ����5:37:52
 */

public class JavaFiledGetSet {
	/**
	 * ���Ե�Դ����Ϣ
	 */
	private String fieldInfo;
	/**
	 * get������Դ����Ϣ��:public int getUserId();
	 */
	private String getInfo;
	/**
	 * set������Դ����Ϣ
	 */
	private String setInfo;
	
	
	public JavaFiledGetSet() {
	
	}
	
	public JavaFiledGetSet(String fieldInfo, String getInfo, String setInfo) {
		super();
		this.fieldInfo = fieldInfo;
		this.getInfo = getInfo;
		this.setInfo = setInfo;
	}

	public String getFieldInfo() {
		return fieldInfo;
	}

	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}

	public String getGetInfo() {
		return getInfo;
	}
	public void setGetInfo(String getInfo) {
		this.getInfo = getInfo;
	}
	public String getSetInfo() {
		return setInfo;
	}
	public void setSetInfo(String setInfo) {
		this.setInfo = setInfo;
	}

	@Override
	public String toString() {
		System.out.println(fieldInfo);
		System.out.println(getInfo);
		System.out.println(setInfo);
		return super.toString();
	}
	
	
}
