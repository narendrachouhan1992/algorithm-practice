package sortings;

import java.util.Arrays;

public class BubbleSort {
	public int[] binarySearch(int[] arr)
	{
		for (int i=0;i<arr.length;i++) {
			for (int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j])
				{
					arr = swap(arr, i,j);
				}
			}
		}
		return arr;
	}
	private int[] swap(int[] arr,int i,int j)
	{
		int x= arr[i];
		arr[i] = arr[j];
		arr[j] = x;
		return arr;
	}
	public static void main(String args[])
	{
		int[] arr = {1,5,6,7,3,90,32,77};
		System.out.println(Arrays.toString(arr));
		BubbleSort bSearch = new BubbleSort(); 
		arr = bSearch.binarySearch(arr);
		System.out.println(Arrays.toString(arr));
	}
}
