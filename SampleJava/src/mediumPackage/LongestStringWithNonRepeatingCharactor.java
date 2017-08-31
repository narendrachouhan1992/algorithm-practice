package mediumPackage;


public class LongestStringWithNonRepeatingCharactor {
	static int[] arr = new int[256];
	static int getLength(String input)
	{
		int curr_max=1;
		int max = 1;
		int previousindex = -1;
		for(int i=0;i<256;i++)
		{
			arr[i] = -1;
		}
		arr[input.charAt(0)]= 0;
		for(int i =1;i<input.length();i++)
		{
			previousindex = arr[input.charAt(i)];
			
			if(previousindex ==-1 || i-curr_max >previousindex)
			{
				curr_max++;
			}
			else
			{
				if (curr_max > max)
	                max = curr_max;
	 
	            curr_max = i - previousindex;
			}
			arr[input.charAt(i)] = i;
		}
		if(curr_max>max)
		{
			return curr_max;
		}
		return max;
	}
	public static void main(String[] args) {
		System.out.println(getLength("ABDEFGABEF"));;
	}
}
