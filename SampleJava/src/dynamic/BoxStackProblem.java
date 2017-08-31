package dynamic;

import java.util.Arrays;

public class BoxStackProblem {
	static class Box implements Comparable {
		int h, w, d;

		@Override
		public int compareTo(Object box) {
			return Integer.compare(d*w, ((Box)box).d*((Box)box).w);
		}
		public Box(int h,int w,int d) {
			this.h=h;
			this.w=w;
			this.d=d;
		}
	}

	static int heightOfStack(Box[] arr)
	{
		int size = arr.length;
		Box[] rot = new Box[3*size];
		int index = 0;
		for(int i=0;i<size;i++)
		{
			// Copy the original box
		      rot[index] = arr[i];
		      index++;
		 
		      // First rotation of box
		      rot[index] = new Box(arr[i].w, Math.max(arr[i].h, arr[i].d), Math.min(arr[i].h, arr[i].d));
		      index++;
		 
		      // Second rotation of box
		      rot[index] = new Box(arr[i].d, Math.max(arr[i].h, arr[i].w), Math.min(arr[i].h, arr[i].w));
		      index++;
		}
		size*=3;
		Arrays.sort(rot);
		int[] msh= new int[size];
		for (int i = 0; i < size; i++ )
		      msh[i] = rot[i].h;
		for (int i = 1; i < size; i++ )
		{	
			for (int j = 0; j < i; j++ )
			{	
				if ( rot[i].w < rot[j].w && rot[i].d < rot[j].d && msh[i] < msh[j] + rot[i].h)
				{
					msh[i] = msh[j] + rot[i].h;
				}
			}
		}
		int max = -1;
		   for ( int i = 0; i < size; i++ )
		      if ( max < msh[i] )
		         max = msh[i];
		return max;
	}
	public static void main(String[] args) {
		Box arr[] = new Box[4];
		arr[0] = new Box(4, 6, 7);
		arr[1] = new Box(1, 2, 3);
		arr[2] = new Box(4, 5, 6);
		arr[3] = new Box(10, 12, 32); 
		System.out.println("The maximum possible height of stack is "+ heightOfStack (arr) );
		 
	}
}
