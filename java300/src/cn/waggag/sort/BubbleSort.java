package cn.waggag.sort;

import java.util.Arrays;
/**
 * ð���㷨��Ƚ���
 * @author ����
 * 2018��4��11�� ����6:10:33
 */
public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr =  {9,8,7,6,5};
		finalbubblesort(arr);
		int[] arr2 =  {9,8,7,6,5};
		bubblesort(arr2);
	}
	/**
	 * ���հ汾��ð���㷨
	 * @param arr
	 */
	public static void finalbubblesort(int[] arr) {
		boolean sorted = true;
		int len = arr.length;
		int i=0;
		
		for(int j=0;j<len-1;j++) 
		{
			System.out.println("��"+(j+1)+"��");
			for(i=0;i<arr.length-j-1;i++)
			{
				sorted = true;	//�ٶ�����
				System.out.print("��"+(i+1)+"��");
				if(arr[i] > arr[i+1])
				{
					int temp =arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					sorted = false; //�ٶ�ʧ��
				}
				System.out.println(Arrays.toString(arr));
			}
			System.out.println();
			/**
			 * �������,���ٴ���
			 */
			if(sorted)
			{
				break;
			}
		}
	}
	/**
	 * �Ľ�ð�������㷨
	 * @param arr
	 */
	public static void bubblesort(int[] arr) {
		int len = arr.length;
		int i=0;
		
		for(int j=0;j<len-1;j++) 
		{
			System.out.println("��"+(j+1)+"��");
			for(i=0;i<arr.length-j-1;i++)
			{
				System.out.print("��"+(i+1)+"��");
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
	 * �򵥵�ð���㷨
	 * @param arr
	 */
	public static void simplesort(int[] arr){
		int i=0;
		System.out.println("��һ��");
		for(i=0;i<arr.length-1;i++)
		{
			System.out.print("��"+(i+1)+"��");
			if(arr[i] > arr[i+1])
			{
				int temp =arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = temp;
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("�ڶ���");
		for(i=0;i<arr.length-1;i++)
		{
			System.out.print("��"+(i+1)+"��");
			if(arr[i] > arr[i+1])
			{
				int temp =arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = temp;
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("������");
		for(i=0;i<arr.length-1;i++)
		{
			System.out.print("��"+(i+1)+"��");
			if(arr[i] > arr[i+1])
			{
				int temp =arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = temp;
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("������");
		for(i=0;i<arr.length-1;i++)
		{
			System.out.print("��"+(i+1)+"��");
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
