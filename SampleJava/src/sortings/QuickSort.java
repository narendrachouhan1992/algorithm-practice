package sortings;

import java.util.Arrays;

public class QuickSort 
{
	public void quickSort(int[] arr,int low,int high)
	{
		if(low<high)
		{
			int pi = findPivoit(arr,low,high);
			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);
		}
	}
	public int findPivoit(int[] arr,int low,int high)
	{
		int pivot = arr[high]; 
		int i = (low-1); // index of smaller element
		for (int j=low; j<=high-1; j++)
		{
		    // If current element is smaller than or
		    // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
		 
		        // swap arr[i+1] and arr[high] (or pivot)
		        int temp = arr[i+1];
		        arr[i+1] = arr[high];
		        arr[high] = temp;
		 
		        return i+1;
		
	}
	public static void main(String Args[])
	 {
		int[] arr = {1,5,6,7,3,90,32,77};
		System.out.println(Arrays.toString(arr));
		QuickSort ms = new QuickSort();
		ms.quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	 }
}
