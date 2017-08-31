package interview;

public class CircleRadius {
	 static int findNumberofIntegerPoints(int radius) {
	    int count = 0;
	    for (int i=(-1)*radius;i<=radius;i++)
	    {
	    	for(int j= (-1)*radius;j<=radius;j++)
	    	{
	    		if(i*i+ j*j == radius*radius)
	    		{
	    			count ++;
	    		}
	    	}
	    }
	    return count;
	 }
	 public static void main(String args[])
	 {
		 
		 System.out.println(CircleRadius.findNumberofIntegerPoints(10));
	 }
}

