package dynamic;

public class MatrixRotation {
	public static void rotMat(int[][] mat)
	{
		int size = mat.length;
//		for(int i=0;i<size/2; i++)
//		{
//			for(int j=i;j<(size-i-1);j++)
//			{
//				int temp = mat[i][j];
//				mat[i][j]= mat[i][size-j-1];
//				mat[i][size-j-1] = mat[size-i-1][size-j-1];
//				mat[size-i-1][size-j-1] = mat[size-1-j][j];
//				mat[size-1-1][j] = temp;
//			}
//		}
		for (int x = 0; x < size / 2; x++)
	    {
	        // Consider elements in group of 4 in 
	        // current square
	        for (int y = x; y < size-x-1; y++)
	        {
	            // store current cell in temp variable
	            int temp = mat[x][y];
	 
	            // move values from right to top
	            mat[x][y] = mat[y][size-1-x];
	 
	            // move values from bottom to right
	            mat[y][size-1-x] = mat[size-1-x][size-1-y];
	 
	            // move values from left to bottom
	            mat[size-1-x][size-1-y] = mat[size-1-y][x];
	 
	            // assign temp to left
	            mat[size-1-y][x] = temp;
	        }
	    }
		printArray(mat);
	}
	static void printArray(int[][] mat)
	{
		int size = mat.length;
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print(mat[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] mat=
		    {
		        {1, 2, 3, 4},
		        {5, 6, 7, 8},
		        {9, 10, 11, 12},
		        {13, 14, 15, 16}
		    };
		 printArray(mat);
		System.out.println();
		    // Tese Case 2
		    /* int mat[N][N] = {
		                        {1, 2, 3},
		                        {4, 5, 6},
		                        {7, 8, 9}
		                    };
		     */
		 
		    // Tese Case 3
		    /*int mat[N][N] = {
		                    {1, 2},
		                    {4, 5}
		                };*/
		 
		    //displayMatrix(mat);
		 
		rotMat(mat);
	}
}
