package interview;

public class ArrayProblem {
	 static int getCountOfPossibleTeams(int[] coders) 
	 {
		 return (countDecremental(coders, 0, 0, 0, coders[0]) + countDecremental(coders, 1, 1, 1, coders[0]) 
		 + countDecremental(coders, 0, 0, 0, coders[0]) + countDecremental(coders,1, 1, 1, coders[0]));
	 }
	 static int countIncremental(int[] input,int i,int last, int already, int size)
	 {
		 
		 int count = 0;
		 if(i==size+1)
		 {
			 return 0;
		 }
		 if(already==3)
			 return 1;
		 else
		 {
			for(int x = i+1;x<size+1;x++)
			{
				if(last!=0 && input[last]<input[x])
				count += (countIncremental(input, x, last, already, size)+ countIncremental(input, x, x, already+1, size));
				if(last==0)
				{
					count+= (countIncremental(input, x, last, already, size)+ countIncremental(input, x, x, already+1, size));
				}
			}
		 }
		 return count;
	 }
	 static int countDecremental(int[] input,int i,int last, int already, int size)
	 {
		 int count = 0;
		 if(i==size+1)
		 {
			 return 0;
		 }
		 if(already==3)
			 return 1;
		 else
		 {
			for(int x = i+1;x<size+1;x++)
			{
				if(last!=0 && input[last]>input[x])
				count += (countDecremental(input, x, last, already,size)+ countDecremental(input, x, x, already+1, size));
				if(last==0)
				{
					count+= (countIncremental(input, x, last, already,size)+ countIncremental(input, x, x, already+1, size));
				}
			}
		 }
		 return count;
	 }
	 public static void main(String[] args) {
		 int[] arr = {5,2,3,1,4};
		System.out.println(getCountOfPossibleTeams(arr));
	}
}
