package test;

public class Sortr {
	
	public static void main(String[] args)
	{
		double a[] = {46,30,32,40,6,17,45,15,48,26};
		sort(a);
		//遍历数组
		for(double temp: a)
		{
			System.out.print((int)temp+" ");
		}
	}
	
	public static void sort(double[] a) {
		int j = 0;
		double ave = 0.0;
		double[] b = new double[a.length];
		//计算平均值
		for(int i=0;i<a.length;i++)
		{
			ave = ave + a[i]/a.length;
		}
		
		//大的元素放到数组前面
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>ave)
			{
				b[j++] = a[i];
			}
		}
		
		//把小于平均数的元素放到数组后面,元素与平均值可能相等,没有处理
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<=ave)
			{
				b[j++] = a[i];
			}
		}
		
		//把元素复制到原数组
		for(int i=0; i<b.length;i++)
		{
			a[i] = b[i];
		}
		
	}	
}
