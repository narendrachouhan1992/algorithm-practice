package dynamic;

public class LongestSumContigiousArrayRecursive {
	static int maxSubArraySum(int[] arr)
	{
		int size = arr.length;
		int maxSumSoFar = 0;
		int maxEndingHere = 0;
		for(int i=0;i<size;i++)
		{
			maxEndingHere+=arr[i];
			if(maxEndingHere> maxSumSoFar)
				maxSumSoFar= maxEndingHere;
			if(maxEndingHere<0)
				maxEndingHere = 0;
		}
		return maxSumSoFar;
	}
	public static void main (String[] args)
	    {
	        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
	        System.out.println("Maximum contiguous sum is " +
	                                       maxSubArraySum(a));
	    }
}
