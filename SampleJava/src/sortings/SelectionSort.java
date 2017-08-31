package sortings;

import java.util.Arrays;

public class SelectionSort 
{
	public static void main(String[] args) 
	{
		int[] arr = {1,5,6,7,3,90,32,77};
		System.out.println(Arrays.toString(arr));
		SelectionSort ss = new SelectionSort();
		ss.selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public void selectionSort (int[] arr)
	{
		for(int i= 0;i<arr.length-1;i++)
		{
			int min_indx = i;
			for (int j= i+1; j<arr.length;j++)
			{
				if(arr[min_indx]> arr[j])
				{
					min_indx = j;
				}
			}
			int temp = arr[min_indx];
			arr[min_indx] = arr[i];
			arr[i] = temp;
		}
	}
}
