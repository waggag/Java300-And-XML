package cn.waggag.pattern.brige;
/**
 * �������ģʽ,ģ��ɱ�������ɱ��
 * @author waggag
 * 2018��5��2�� ����10:08:22
 */
public class Client2 {
	public static void main(String[] args) {
		AbstractFile f2,f3;
		Folder f = new Folder("�ҵ��ղ�");
		
		f2 = new ImagesFile("����.jpg");
		f3 = new TextFile("a.txt");
		f.add(f2);
		
		f.killFiles();
		System.out.println("--------------");
		f3.killFiles();
		
		
	}
}
