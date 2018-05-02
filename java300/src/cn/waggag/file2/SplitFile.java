package cn.waggag.file2;

import java.io.File;
import java.util.List;

/**
 * �ָ��ļ�
 * @author waggag
 * 2018��4��17�� ����8:27:50
 */
public class SplitFile {
	//�ļ���·��
	private String filePath;
	//ÿ��Ĵ�С
	private long blockSize;
	//ÿ�������
	@SuppressWarnings("unused")
	private List<String> blockPath;
	
	public SplitFile(String filePath) {
		this(filePath, 1024);
	}

	public SplitFile(String filePath, int blockSize) {
		super();
		this.filePath = filePath;
		this.blockSize = blockSize;
	}
	/**
	 * ��ʼ������,�������,ȷ���ļ���
	 */
	public void init() {
		File src = null;
		if(null == filePath || !((src = (new File(filePath))).exists())) {
			return ;
		}
		//������� ʵ�ʴ�С��ÿһ��Ĵ�С
		long length = src.length();
		if(this.blockSize>length) {
			this.blockSize = length;
		}
	}
	
}
