package newDynamic;

import java.util.Arrays;
class Box implements Comparable<Box>
{
	int h;
	int w;
	int d;
	public Box() {
		// TODO Auto-generated constructor stub
	}
	public Box(int h, int w, int d) {
		this.h = h;
		this.w = w;
		this.d = d;
	}
	@Override
	public int compareTo(Box o) {
		if(this.w*this.d> o.w*o.d)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}
public class BoxStacking {
	
	static int getMaxHeight(Box[] arr)
	{
		int size = arr.length;
		Box[] rot = new Box[size*3];
		int index = 0;
		int[] dp;
		for(int i =0;i<size;i++)
		{
			rot[index] = arr[i];
			index++;
			
			rot[index] = new Box();
			rot[index].h = arr[i].w;
			rot[index].w = Integer.max(arr[i].h, arr[i].d);
			rot[index].d = Integer.min(arr[i].h, arr[i].d);
			index++;
			
			rot[index] = new Box();
			rot[index].h = arr[i].d;
			rot[index].w = Integer.max(arr[i].h, arr[i].w);
			rot[index].d = Integer.min(arr[i].h, arr[i].w);
			index++;
		}
		Arrays.sort(rot);
		size = size*3;
		dp = new int[size];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = rot[i].h;
		}
		int max = Integer.MIN_VALUE;
		for(int i =1;i<size;i++)
		{
			for(int j = 0;j<i;j++)
			{
				if(rot[i].w>rot[j].w && rot[i].d>rot[j].d && dp[i]<dp[j]+rot[i].h)
				{
					dp[i] = dp[j]+rot[i].h;
					if(dp[i]>max)
						max=dp[i];
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {
		 Box[] arr = new Box[4];
		 arr[0] = new Box(4, 6, 7);
		 arr[1] = new Box(1, 2, 3);
		 arr[2] = new Box(4, 5, 6);
		 arr[3] = new Box(10, 12, 32);
		 System.out.println(getMaxHeight(arr));
	}
}
