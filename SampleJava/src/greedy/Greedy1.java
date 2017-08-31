package greedy;
//Consider the following 6 activities 
//sorted by by finish time.
//    start[]  =  {1, 3, 0, 5, 8, 5};
//    finish[] =  {2, 4, 6, 7, 9, 9};
//A person can perform at most four activities. The 
//maximum set of activities that can be executed 
//is {0, 1, 3, 4} [ These are indexes in start[] and 
//finish[] ]
public class Greedy1 {
	int[] start  =  {1, 3, 0, 5, 8, 5};
	int[] finish = {2, 4, 6, 7, 9, 9};
	public static void main(String[] args)
	{
		Greedy1 g = new Greedy1();
		g.greedy(5);
	}
	public void greedy(int time)
	{
		int i=0;
		for(int j= 0;j<time;j++)
		{
			if(start[j]>i)
			{
				System.out.println(j);
				i = finish[j];
				
			}
		}
	}
}
