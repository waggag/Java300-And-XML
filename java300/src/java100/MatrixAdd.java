package java100;
/**
 * 封装矩阵的加法
 * @author 王港
 *
 */
public class MatrixAdd {
	/**
	 * 矩阵相加
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[][] add(int[][] a,int[][] b)
	{
		int[][] c=new int[a.length][a.length];
		for(int i=0;i<c.length;i++)
			for(int j=0;j<c.length;j++)
				c[i][j]=a[i][j]+b[i][j];
		return c;
		
	}
	/**
	 * 打印矩阵
	 * @param c
	 */
	public static void print(int[][] c) 
	{
		for(int i=0;i<c.length;i++)
		{
			for(int j=0;j<c.length;j++)
			{
				System.out.print(c[i][j]);
				System.out.print("\t");
				
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int [][] a= {
				{ 1,3,3},
				{ 2,4,6},
				{ 3,7,5}
		};
		int [][] b= {
				{ 3,4,6 },
				{ 5,6,9 },
				{ 5,8,10}
		};
		int[][] c=add(a,b);
		print(c);
	}
}
