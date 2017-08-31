package sortings;

import java.util.ArrayDeque;
import java.util.Arrays;

public class LargestUsortedArrayWhichWillSoftWholeArray {
	public void printUnsorted(int[] arr)
	{
		int n = arr.length;
		int s,e,max,min;
		for(s=0;s<n;s++)
		{
			if(arr[s]>arr[s+1])
			{
				break;
			}
		}
		if(s==n-1)
		{
			System.out.println("all array is sorted");
		}
		for(e=n-1;e>=0;e--)
		{
			if(arr[e]<arr[e-1])
			{
				break;
			}
		}
		min = arr[s];
		max=arr[e];
		for(int i= s+1;i<e;i++){
			if(arr[i]>max)
			{
				max=arr[i];
			}
			if(arr[i]<min)
			{
				min= arr[i];
			}
		}
		for(int i = 0; i < s; i++)
		{
			if(arr[i] > min)
			{  
				s = i;
				break;
			}      
		}
	  
		  // step 2(c) of above algo
		for(int i = n -1; i >= e+1; i--)
		{
			if(arr[i] < max)
			{
				e = i;
		    	break;
			} 
		}
		System.out.println(" The unsorted subarray which makes the given array \n sorted lies between the indees"+ s+" and "+e);
	}
	public static void main(String args[])
	{
		int[] arr = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		System.out.println(Arrays.toString(arr));
		LargestUsortedArrayWhichWillSoftWholeArray obj = new LargestUsortedArrayWhichWillSoftWholeArray();
		obj.printUnsorted(arr);
	}
}
