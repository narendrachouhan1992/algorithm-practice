package newDynamic;

import java.util.Arrays;

public class RemoveMinimumElementsEitherSide2minMaxRec {
	static int getNumberOfChanges(int[] arr, int start, int end)
	{
		if(start>=end)
		{
			return 0; 
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = start;i<=end;i++)
		{
			if(arr[i]>max)
			{
				max = arr[i];
			}
			if(arr[i]<min)
			{
				min= arr[i];
			}
		}
		if(min*2>max)
			return 0;
		return (1 + Integer.min(getNumberOfChanges(arr, start+1, end), getNumberOfChanges(arr, start, end-1)));
	}
	public static void main(String[] args) {
		int[] arr = {4, 5, 100, 9, 10, 11, 12, 15, 200};
		System.out.println(getNumberOfChanges(arr, 0, arr.length-1));
	}
}
