package dynamic;

public class LISRecusrive2 {
	static int lis(int[] arr, int n)
	{
		if(n == 1)
		{
			return 1;
		}
		else
		{
			if(arr[n-1]>arr[n-2])
			{
				return (lis(arr, n-1)+1);
			}
			else
			{
				return lis(arr, n-1);
			}
		}
	}
	public static void main(String args[])
	{
	    int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 70, 80, 100};
	    int n = arr.length;
	    System.out.println("Length of LIS is " + lis( arr, n ));
	} 
}
