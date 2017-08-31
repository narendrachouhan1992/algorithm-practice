package amazone;

public class MissingNumberInSortedArray {
	static int missingNumber(int[] arr, int start, int end)
	{
		if(start== end && arr[start]==start+1)
			return start+2;
		if(start == end && arr[start]==start+2)
			return start +1;
			
		if(start+1 == end && arr[start]== start+1 && arr[end]== end+2)
			return end+1;
		if(start+1 == end && arr[start]== start+2 && arr[end]== end+2)
			return start+1;
		
		int mid = (start+end)/2;
		if(arr[mid] == mid+1)
		{
			return missingNumber(arr, mid+1, end);
		}
		else
		{
			return missingNumber(arr, start, mid);
		}
	}
}
