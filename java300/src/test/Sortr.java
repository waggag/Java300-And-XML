package test;

public class Sortr {
	
	public static void main(String[] args)
	{
		double a[] = {46,30,32,40,6,17,45,15,48,26};
		sort(a);
		//��������
		for(double temp: a)
		{
			System.out.print((int)temp+" ");
		}
	}
	
	public static void sort(double[] a) {
		int j = 0;
		double ave = 0.0;
		double[] b = new double[a.length];
		//����ƽ��ֵ
		for(int i=0;i<a.length;i++)
		{
			ave = ave + a[i]/a.length;
		}
		
		//���Ԫ�طŵ�����ǰ��
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>ave)
			{
				b[j++] = a[i];
			}
		}
		
		//��С��ƽ������Ԫ�طŵ��������,Ԫ����ƽ��ֵ�������,û�д���
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<=ave)
			{
				b[j++] = a[i];
			}
		}
		
		//��Ԫ�ظ��Ƶ�ԭ����
		for(int i=0; i<b.length;i++)
		{
			a[i] = b[i];
		}
		
	}	
}
