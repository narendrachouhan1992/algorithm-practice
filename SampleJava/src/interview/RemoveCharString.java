package interview;

import java.util.Arrays;

public class RemoveCharString {
	static String[] getShrunkArray(String[] inputArray, int burstLength) {
		
		int size = inputArray.length;
		int[] firstOcc = new int[size];
		for(int i=0;i<size;i++)
		{
			System.out.println(inputArray[i]);
		}
		for(int i=1;i<size;i++)
		{
			firstOcc[i]= -1;
		}
		firstOcc[0] = 0;
		for(int i=1;i<size;i++)
		{
			if(i==0)
			{
				firstOcc[0]= 0;
			}
			else if(inputArray[i].equals(inputArray[i-1]) && (i-firstOcc[i-1] == 2))
			{
				int j=i+1; 
				while(inputArray[j].equals(inputArray[i]) && j < size)
				{
					j++;
				}
				j--;
				i = i-3;
				firstOcc[i+1]=-1;
				firstOcc[i+2] =-1;
				String replaceString= "";
				for(int p=0;p<(j-1);p++)
				{
					replaceString += inputArray[j].charAt(0);
				}
				String temp = Arrays.toString(inputArray);
				temp.replaceAll(replaceString, "");
				inputArray = temp.split("");
				size = inputArray.length;
			}
			else if (inputArray[i].equals(inputArray[i-1]))
			{
				firstOcc[i] = firstOcc[i-1];
			}
			else
			{
				firstOcc[i]= i;
			}
		}
		
		return inputArray;
    }
	static void removeFrom(int x, int y)
	{
		
	}
}
