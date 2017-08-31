package amazone;

public class MaxElementOfBitonicArray {
	static int getMaxElement(int[] arr,int low,int high)
	{
		if(low==high)
			return arr[low];
		if(low+1==high && arr[low]>arr[high])
			return arr[low];
		if(low+1==high && arr[low]<arr[high])
			return arr[high];
		int mid = (low+high)/2;
		
		if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1])
			return arr[mid];
		
		if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1])
			return getMaxElement(arr, mid+1, high);
		else
			return getMaxElement(arr, low, mid-1);
	}
	public static void main (String[] args) 
    {
        int arr[] = {1, 3, 50, 10, 9, 7, 6};
        int n = arr.length;
        System.out.println("The maximum element is "+ 
        		getMaxElement(arr, 0, n-1));
    }
}
