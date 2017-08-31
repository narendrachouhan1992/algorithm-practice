package dynamic;

public class CutRodRecursive {
	static int cutRod(int[] price, int length){
		if(length <=0)
			return 0;
		else
		{
			int max= Integer.MIN_VALUE;
			for(int i=0;i<length;i++)
			{
				max= Math.max(max, (price[i]+cutRod(price, length-i-1)));
			}
			return max;
		}
	}
	 public static void main(String args[])
	    {
	        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
	        int size = arr.length;
	        System.out.println("Maximum Obtainable Value is "+
	                            cutRod(arr, size));
	 
	    }
}
