package amazone;

public class ExtraElementInSortedArray {
	static int getExtraElement(int[] arr1, int[] arr2, int start,int end)
	{
		int mid = (start+end)/2;
		if(start > end)
			return start;
		if(arr1[mid] == arr2[mid])
		{
			return getExtraElement(arr1, arr2, mid+1, end);
		}
		else
		{
			return getExtraElement(arr1, arr2, start, mid-1);
		}
	}
	 public static void main (String[] args)
	    {
	        int arr1[]  =  {2, 4, 6, 8, 10, 12,13};
	        int arr2[] =  {2, 4, 6, 8, 10, 12};
	        int n = arr2.length;
	      
	        // Solve is passed both arrays
	        System.out.println(getExtraElement(arr1, arr2,0, n-1));
	    }
}
