package dynamic;

public class CutRodDynamic {
	static int cutRod(int[] price, int length) {
		int[] maxProfit = new int[length+1];
		maxProfit[0] = 0;
		for(int i=1;i<=length;i++)
		{
			int max =Integer.MIN_VALUE;
			for(int j=0;j<i;j++)
			{
				max = Math.max(max, price[j]+maxProfit[i-j-1]);
			}
			maxProfit[i]= max;
		}
		return maxProfit[length];
	}

	public static void main(String args[]) {
		int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		int size = arr.length;
		System.out.println("Maximum Obtainable Value is " + cutRod(arr, size));

	}
}
