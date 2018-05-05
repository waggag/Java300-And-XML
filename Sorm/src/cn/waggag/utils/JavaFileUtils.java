package cn.waggag.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.waggag.bean.ColumnInfo;
import cn.waggag.bean.JavaFiledGetSet;
import cn.waggag.bean.TableInfo;
import cn.waggag.core.DBManager;
import cn.waggag.core.MysqlTypeConvertorl;
import cn.waggag.core.TableContext;
import cn.waggag.core.TypeConvertor;

/**
 * ��װ��java�ļ����õĲ���(Դ����)
 * @author waggag
 * 2018��5��5�� ����12:17:16
 */
public class JavaFileUtils {
	
	/**
	 * �����ֶ���Ϣ����java������Ϣ���磺varchar username-->private String username;�Լ���Ӧ��set��get����Դ��
	 * @param column �ֶ���Ϣ
	 * @param convertor ����ת����
	 * @return java���Ժ�set/get����Դ��
	 */
	public static JavaFiledGetSet createFieldGetSetSRC(ColumnInfo column,TypeConvertor convertor){
		
		JavaFiledGetSet jfgs  = new JavaFiledGetSet();
		
		//�����ݿ���������ת����java����������
		String javaFieldType = convertor.databaseType2JavaType(column.getDataType());
		
		//���ɶ������Եķ���
		jfgs.setFieldInfo("\tprivate "+javaFieldType+" "+column.getName()+";\n");
		
		//public String getUsername(){return username;}
		//����get������Դ����
		StringBuilder getSrc = new StringBuilder();
		getSrc.append("\tpublic "+javaFieldType+" get"+StringUtils.firstChar2UpperCase(column.getName())+"(){\n");
		getSrc.append("\t\treturn "+column.getName()+";\n");
		getSrc.append("\t}\n\n");
		jfgs.setGetInfo(getSrc.toString());
		
		//public void setUsername(String username){this.username=username;}
		//����set������Դ����
		StringBuilder setSrc = new StringBuilder();
		setSrc.append("\tpublic void set"+StringUtils.firstChar2UpperCase(column.getName())+"(");
		setSrc.append(javaFieldType+" "+column.getName()+"){\n");
		setSrc.append("\t\tthis."+column.getName()+"="+column.getName()+";\n");
		setSrc.append("\t}\n\n");
		jfgs.setSetInfo(setSrc.toString());
		return jfgs;
		
	}
	
	/**
	 * ���ݱ���Ϣ����java���Դ����
	 * @param tableInfo ����Ϣ
	 * @param convertor ��������ת���� 
	 * @return java���Դ����
	 */
	public static String createJavaSrc(TableInfo tableInfo,TypeConvertor convertor){
		
		Map<String,ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFiledGetSet> javaFields = new ArrayList<JavaFiledGetSet>();

		for(ColumnInfo c:columns.values()){
			javaFields.add(createFieldGetSetSRC(c,convertor));
		}
		
		StringBuilder src = new StringBuilder();
		
		//����package���
		src.append("package "+DBManager.getConf().getPoPackage()+";\n\n");
		//����import���
		src.append("import java.sql.*;\n");
		src.append("import java.util.*;\n\n");
		//�������������
		src.append("public class "+StringUtils.firstChar2UpperCase(tableInfo.getTname())+" {\n\n");
		
		//���������б�
		for(JavaFiledGetSet f:javaFields){
			src.append(f.getFieldInfo());
		}
		src.append("\n\n");
		//����get�����б�
		for(JavaFiledGetSet f:javaFields){
			src.append(f.getGetInfo());
		}
		//����set�����б�
		for(JavaFiledGetSet f:javaFields){
			src.append(f.getSetInfo());
		}
		
		//���������
		src.append("}\n");
		//System.out.println(src);
		return src.toString();
	}
	
	
	public static void createJavaPOFile(TableInfo tableInfo,TypeConvertor convertor){
		
		String src = createJavaSrc(tableInfo,convertor);
		
		String srcPath = DBManager.getConf().getSrcPath()+"\\";
		String packagePath = DBManager.getConf().getPoPackage().replaceAll("\\.", "/");
		
		File f = new File(srcPath+packagePath);
		
		if(!f.exists()){  //���ָ��Ŀ¼�����ڣ�������û�����
			f.mkdirs();
		}
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile()+"/"+
				StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java"));
			bw.write(src);
			System.out.println("������"+tableInfo.getTname()+
					"��Ӧ��java�ࣺ"+StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(bw!=null){
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		//����get set����
//		ColumnInfo ci = new ColumnInfo("id", "int", 0);
//		JavaFiledGetSet f = createFieldGetSetSRC(ci,new MysqlTypeConvertorl());
//		System.out.println(f);
		
		//����java��Դ��
//		Map<String,TableInfo> map = TableContext.tables;
//		TableInfo t = map.get("emp");
//		createJavaSrc(t,new MysqlTypeConvertorl());
		
		//��������������java�ļ�
		Map<String,TableInfo> map = TableContext.tables;
		for(TableInfo t:map.values()){
			createJavaPOFile(t,new MysqlTypeConvertorl());
		}
		
	}

}
