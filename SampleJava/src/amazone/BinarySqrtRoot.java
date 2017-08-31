package amazone;

public class BinarySqrtRoot {
	int sqrt(int n)
	{
		if(n== 1 || n==0)
			return n;
		int start = 0;
		int end = n;
		int ans = (start+end)/2;
		while(start<=end)
		{
			int mid = (start+end)/2;
			if(mid*mid == n)
				return mid;
			else if(mid*mid<n)
			{
				start = mid+1;
				ans = mid;
			}
			else
			{
				end = mid-1;
			}
		}
		return ans;
	}
}
