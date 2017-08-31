package mediumPackage;

public class SuperUglyNymber {
	static int getSuperUglyNumber(int n,int[] prime)
	{
		int[] ugly = new int[n];
		ugly[0]=1;
		int size = prime.length;
		
		int[] i_count = new int[size];
		for(int k=0;k<size;k++)
		{
			i_count[k] = 0;
		}
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		
		int next_2 = 2;
		int next_3 = 3;
		int next_5 = 5;
		int next_ugly;
		
		for(int x=1;x<n;x++)
		{
			int index = 0;;
			int min = Integer.MAX_VALUE;
			for(int i=0;i<size;i++)
			{
				if(min>prime[i])
				{
					min = prime[i];
					index = i;
				}
			}
			ugly[x] = min;
			i_count[index] =i_count[index]+1; 
			
			
			
			next_ugly = Math.min(Math.min(next_2, next_3), next_5);
			ugly[x]= next_ugly;
			if(next_ugly==next_2)
			{
				i2++;
				next_2 = ugly[i2]*2;
			}
			if(next_ugly==next_3)
			{
				i3++;
				next_3 = ugly[i3]*3;
			}
			if(next_ugly==next_5)
			{
				i5++;
				next_5 = ugly[i5]*5;
			}
		}
		return ugly[n-1];
	}
	
	public static void main(String[] args) {
		System.out.println(getSuperUglyNumber(150));
	}
}
