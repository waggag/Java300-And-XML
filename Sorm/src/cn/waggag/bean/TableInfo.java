package cn.waggag.bean;

import java.util.List;
import java.util.Map;

/**
 * �洢��Ľṹ��Ϣ
 * @author waggag
 * 2018��5��5�� ����12:25:31
 */
public class TableInfo {
	
	/**
	 * ����
	 */
	private String tname;  
	
	/**
	 * �����ֶε���Ϣ
	 */
	private Map<String,ColumnInfo> columns;
	
	/**
	 * Ψһ����(Ŀǰ����ֻ�ܴ����������ֻ��һ�����������)
	 */
	private ColumnInfo  onlyPriKey;
	
	
	/**
	 * ���������������������洢
	 */
	private List<ColumnInfo> priKeys;

	public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey, List<ColumnInfo> priKeys) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
		this.priKeys = priKeys;
	}   
	
	public TableInfo() {
		
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}

	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}

	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}

	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}

	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}
	
}
