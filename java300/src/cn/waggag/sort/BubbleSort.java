package cn.waggag.sort;

import java.util.Arrays;
/**
 * 冒泡算法深度解析
 * @author 王港
 * 2018年4月11日 下午6:10:33
 */
public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr =  {9,8,7,6,5};
		finalbubblesort(arr);
		int[] arr2 =  {9,8,7,6,5};
		bubblesort(arr2);
	}
	/**
	 * 最终版本的冒泡算法
	 * @param arr
	 */
	public static void finalbubblesort(int[] arr) {
		boolean sorted = true;
		int len = arr.length;
		int i=0;
		
		for(int j=0;j<len-1;j++) 
		{
			System.out.println("第"+(j+1)+"趟");
			for(i=0;i<arr.length-j-1;i++)
			{
				sorted = true;	//假定有序
				System.out.print("第"+(i+1)+"次");
				if(arr[i] > arr[i+1])
				{
					int temp =arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					sorted = false; //假定失败
				}
				System.out.println(Arrays.toString(arr));
			}
			System.out.println();
			/**
			 * 如果有序,减少次数
			 */
			if(sorted)
			{
				break;
			}
		}
	}
	/**
	 * 改进冒泡排序算法
	 * @param arr
	 */
	public static void bubblesort(int[] arr) {
		int len = arr.length;
		int i=0;
		
		for(int j=0;j<len-1;j++) 
		{
			System.out.println("第"+(j+1)+"趟");
			for(i=0;i<arr.length-j-1;i++)
			{
				System.out.print("第"+(i+1)+"次");
				if(arr[i] > arr[i+1])
				{
					int temp =arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
				System.out.println(Arrays.toString(arr));
			}
			System.out.println();
		}
	}
	/**
	 * 简单的冒泡算法
	 * @param arr
	 */
	public static void simplesort(int[] arr){
		int i=0;
		System.out.println("第一趟");
		for(i=0;i<arr.length-1;i++)
		{
			System.out.print("第"+(i+1)+"次");
			if(arr[i] > arr[i+1])
			{
				int temp =arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = temp;
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("第二趟");
		for(i=0;i<arr.length-1;i++)
		{
			System.out.print("第"+(i+1)+"次");
			if(arr[i] > arr[i+1])
			{
				int temp =arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = temp;
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("第三趟");
		for(i=0;i<arr.length-1;i++)
		{
			System.out.print("第"+(i+1)+"次");
			if(arr[i] > arr[i+1])
			{
				int temp =arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = temp;
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("第四趟");
		for(i=0;i<arr.length-1;i++)
		{
			System.out.print("第"+(i+1)+"次");
			if(arr[i] > arr[i+1])
			{
				int temp =arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = temp;
			}
			System.out.println(Arrays.toString(arr));
		}
	}
}
