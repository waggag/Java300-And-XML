package cn.waggag.pattern.brige;
/**
 * 测试组合模式,模拟杀毒软件的杀毒
 * @author waggag
 * 2018年5月2日 上午10:08:22
 */
public class Client2 {
	public static void main(String[] args) {
		AbstractFile f2,f3;
		Folder f = new Folder("我的收藏");
		
		f2 = new ImagesFile("王港.jpg");
		f3 = new TextFile("a.txt");
		f.add(f2);
		
		f.killFiles();
		System.out.println("--------------");
		f3.killFiles();
		
		
	}
}
