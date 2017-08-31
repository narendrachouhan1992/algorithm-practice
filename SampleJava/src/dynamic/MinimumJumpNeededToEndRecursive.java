package dynamic;

public class MinimumJumpNeededToEndRecursive
{
	public static int getMinStep(int[] arr, int start, int end)
	{
		if(start==end)
			return 0;
		if(arr[start] == 0)
			return Integer.MAX_VALUE;
		int min =Integer.MAX_VALUE;
		for(int i=start+1;i<=start+arr[start] && i<=end;i++)
		{
			int step = getMinStep(arr, i, end);
			if(step+1<min)
				min = step+1;
		}
		return min;
	}
	public static void main(String[] args) {
		int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		System.out.println("Minimum number of jumps to reach end is "+getMinStep(arr, 0, arr.length-1));
	}
}
