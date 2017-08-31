package amazone;

public class SumOfTwoNumEqualThirtNum {
	static boolean find(int[] arr, int num, int one, int pos)
	{
		boolean result= false;
		int n= arr.length;
		for(int i=0;i<n;i++)
		{
			if(i==pos)
			{
				i++;
			}
			else if(one==0 && arr[i]<num)
			{
				if(find(arr, num, arr[i], i)){
					return true;
				}
			}
			else 
			{
				if(arr[i]==num-one)
					return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] arr = {1, 4, 45, 5, 10, 8};
		if(find(arr, 16, 0, -1))
			{
				System.out.println("true");
			}
		else
		{
			System.out.println("false");
		}
	}
}
