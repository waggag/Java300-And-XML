package cn.waggag.pattern.brige;

import java.util.ArrayList;

public interface AbstractFile {
	//杀毒
	void killFiles();
}

class ImagesFile implements AbstractFile{
	private String name;

	
	public ImagesFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killFiles() {
		System.out.println("--图像文件:"+name+", 进行查杀!");
	}
}

class TextFile implements AbstractFile{
	private String name;

	
	public TextFile(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public void killFiles() {
		System.out.println("--文本文件:"+name+", 进行查杀!");
	}
	
}

class Folder implements AbstractFile{
	private String name;
	//构建容器,用来存放本容器下的子节点
	private java.util.List<AbstractFile> list = new ArrayList<AbstractFile>();
	/**
	 * @param name
	 */
	public Folder(String name) {
		super();
		this.name = name;
	}
	
	public void add(AbstractFile File) {
		list.add(File);
	}
	
	public void remove(AbstractFile File) {
		list.remove(File);
	}
	
	public AbstractFile getChild(int index) {
		return list.get(index);
	}
	@Override
	public void killFiles() {
		System.out.println("---文件夹"+ name +"进行查杀!");
		
		for(AbstractFile file : list) {
			file.killFiles();
		}
	}
	
}