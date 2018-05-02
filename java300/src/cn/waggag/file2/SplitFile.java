package cn.waggag.file2;

import java.io.File;
import java.util.List;

/**
 * 分割文件
 * @author waggag
 * 2018年4月17日 下午8:27:50
 */
public class SplitFile {
	//文件的路径
	private String filePath;
	//每块的大小
	private long blockSize;
	//每块的名称
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
	 * 初始化操作,计算块数,确定文件名
	 */
	public void init() {
		File src = null;
		if(null == filePath || !((src = (new File(filePath))).exists())) {
			return ;
		}
		//计算块数 实际大小与每一块的大小
		long length = src.length();
		if(this.blockSize>length) {
			this.blockSize = length;
		}
	}
	
}
