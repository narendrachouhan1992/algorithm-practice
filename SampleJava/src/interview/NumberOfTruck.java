package interview;

import java.util.Scanner;

public class NumberOfTruck {
	public static int numberOfTrcuk()
	{
		int[] from;
		int[] to;
		int size=0;
		Scanner sc = new Scanner(System.in);
		int numberOfTruct = Integer.parseInt(sc.nextLine());
		from = new int[numberOfTruct];
		to = new int[numberOfTruct];
		for(int i=0;i<numberOfTruct;i++)
		{
			String pat = sc.nextLine();
			if(!(Integer.parseInt(pat.substring(0,1))< 1 || Integer.parseInt(pat.substring(2,3))>5))
			{
				size++;
				from[i]= Integer.parseInt(pat.substring(0,1));
				to[i]= Integer.parseInt(pat.substring(2,3));
			}
		}
		int numberOfWays = numberOfWays(from, to, -1,size);
		return numberOfWays;
	}
	public static int numberOfWays(int[] from,int[] to,int x,int size)
	{
		int res=0;
		if(size==0)
		{
			return 0;
		}
		if(x==-1)
		{
			for(int i=0;i<from.length;i++)
			{
				if(from[i]==1)
				{
					from[i]=0;
					int t = to[i];
					to[i]= 0;
					size=size-1;
					res+=numberOfWays(from,to,t, size);
				}
				
			}
		}
		else 
		{
			for(int i=0;i<from.length;i++)
			{
				if(from[i]==x)
				{
					from[i]=0;
					int t = to[i];
					to[i]= 0;
					size = size-1;
					res+=numberOfWays(from,to,t,size);
				}
			}
		}
		return res;
	}
	public static void main(String args[])
	{
		
		NumberOfTruck.numberOfTrcuk();
	}
}
