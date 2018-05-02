package cn.waggag.file2;
/**
 * 扩音器
 * 类与类之间的关系
 * 1.依赖:形参或局部变量
 * 2.关联:属性
 * 		聚合: 属性整体与部分不一致的生命周期
 * 		组合	属性整体与部分一致的生命周期
 * 3.继承	:父子关系
 * 4.实现  :接口与实现类
 * @author waggag
 * 2018年4月17日 下午7:59:09
 */
public class App {
	public static void main(String[] args) {
		Voice v = new Voice();
		v.say();
		Amplifier am = new Amplifier(v);
		am.say();
	}
}
