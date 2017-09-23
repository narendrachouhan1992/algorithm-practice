package newDynamic;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import javax.script.Compilable;
class Job implements Comparable<Job>
{
	int start;
	int end;
	int weight;
	public Job(int start, int end, int weight) {
		this.end = end;
		this.start = start;
		this.weight = weight;
	}
	public Job() {
	}
	public int compareTo(Job compareJob) {

		int compareWeight = ((Job) compareJob).weight;
		if(this.weight>=compareWeight)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}
public class WeightedJobScheduling {
	static int latestNonConflict(Job arr[], int i)
	{
	    for (int j=i-1; j>=0; j--)
	    {
	        if (arr[j].end <= arr[i-1].start)
	            return j;
	    }
	    return -1;
	}
	static int findMaxProfitRec(Job[] arr, int n)
	{
		if (n == 1) return arr[n-1].weight;
		 
	    // Find profit when current job is inclueded
	    int inclProf = arr[n-1].weight;
	    int i = latestNonConflict(arr, n);
	    if (i != -1)
	      inclProf += findMaxProfitRec(arr, i+1);
	 
	    // Find profit when current job is excluded
	    int exclProf = findMaxProfitRec(arr, n-1);
	 
	    return Integer.max(inclProf,  exclProf);

	}
	static int getMaxProfit(Job[] arr)
	{
		Arrays.sort(arr);
		int n = arr.length;
		return findMaxProfitRec(arr, n);
	}
	static int findMaxProfitDynamic(Job[] arr)
	{
		Arrays.sort(arr);
		int n = arr.length;
	    int[] table = new int[n];
	    table[0] = arr[0].weight;
	 
	    // Fill entries in M[] using recursive property
	    for (int i=1; i<n; i++)
	    {
	        // Find profit including the current job
	        int inclProf = arr[i].weight;
	        int l = latestNonConflict(arr, i);
	        if (l != -1)
	            inclProf += table[l];
	 
	        // Store maximum of including and excluding
	        table[i] = Integer.max(inclProf, table[i-1]);
	    }
	 
	    // Store result and free dynamic memory allocated for table[]
	    int result = table[n-1];	 
	    return result;
	}
	public static void main(String[] args) {
		Job[] arr = {new Job(3, 10, 20), new Job(1, 2, 50), new Job(6, 19, 100), new Job(2, 100, 200)};
		System.out.println(getMaxProfit(arr));
	}
}
