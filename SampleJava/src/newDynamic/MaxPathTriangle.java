package newDynamic;

public class MaxPathTriangle {
	static int getMaxSum(int[][] arr)
	{
		int x = arr.length;
		int y = arr[0].length;
		for(int i=x-2;i>=0;i--)
			for(int j = 0;j< y-1;j++)
			{
				if(arr[i+1][j]>arr[i+1][j+1])
					arr[i][j]+=arr[i+1][j];
				else
					arr[i][j]+=arr[i+1][j+1];
			}
		return arr[0][0];
	}
	public static void main(String[] args) {
		int[][] tri = {  {1, 0, 0},
                {4, 8, 0},
                {1, 5, 3} };
		System.out.println(getMaxSum(tri));
	}
}
