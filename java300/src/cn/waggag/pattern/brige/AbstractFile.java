package cn.waggag.pattern.brige;

import java.util.ArrayList;

public interface AbstractFile {
	//ɱ��
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
		System.out.println("--ͼ���ļ�:"+name+", ���в�ɱ!");
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
		System.out.println("--�ı��ļ�:"+name+", ���в�ɱ!");
	}
	
}

class Folder implements AbstractFile{
	private String name;
	//��������,������ű������µ��ӽڵ�
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
		System.out.println("---�ļ���"+ name +"���в�ɱ!");
		
		for(AbstractFile file : list) {
			file.killFiles();
		}
	}
	
}