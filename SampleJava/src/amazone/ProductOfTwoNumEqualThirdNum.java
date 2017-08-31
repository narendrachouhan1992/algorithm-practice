package amazone;

public class ProductOfTwoNumEqualThirdNum {
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
			else if(one==0 && arr[i]*one == num)
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
		int[] arr = {1, 2, 3, 4, 5};
		if(find(arr, 2, 0, -1))
			{
				System.out.println("true");
			}
		else
		{
			System.out.println("false");
		}
	}
}
