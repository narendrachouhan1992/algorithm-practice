package dynamic;

import org.omg.CORBA.MARSHAL;

public class PalendromicCut {
	static int numberOfCutPalendrome(String str)
	{
		int length = str.length();
		boolean[][] isPalendrome = new boolean[length][length];
		int[][] numberOfCutToPalendrome = new int[length][length];
		for(int i=0;i<length ;i++)
		{
			isPalendrome[i][i] = true;
			numberOfCutToPalendrome[i][i]= 0;
		}
		for(int L =2;L<=length;L++)
		{
			for(int i=0;i<length-L+1;i++)
			{
				int j= i+L-1;
				if(L==2)
				{
					isPalendrome[i][j]= (str.charAt(i)==str.charAt(j));
				}
				else
				{
					isPalendrome[i][j] = ((str.charAt(i)==str.charAt(j)) && isPalendrome[i+1][j-1]);
				}
				
				if (isPalendrome[i][j] == true)
				{
					numberOfCutToPalendrome[i][j] = 0;
				}
				else
				{
					numberOfCutToPalendrome[i][j]= Integer.MAX_VALUE;
					for(int k=i;k<j;k++)
					{
						numberOfCutToPalendrome[i][j] = Math.min(numberOfCutToPalendrome[i][j], (numberOfCutToPalendrome[i][k]+numberOfCutToPalendrome[k+1][j]+1));
					}
				}
			}
		}
		return numberOfCutToPalendrome[0][length-1];
	}
	public static void main(String[] args) {
		String str = "ababbbabbababa";
		   System.out.println("Min cuts needed for Palindrome Partitioning is "+ numberOfCutPalendrome(str));
	}
}
