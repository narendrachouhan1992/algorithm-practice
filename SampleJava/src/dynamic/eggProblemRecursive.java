package dynamic;

public class eggProblemRecursive {
	static int eggDrop(int numberOfEggs, int numberOfFloors)
	{
	    // If there are no floors, then no trials needed. OR if there is
	    // one floor, one trial needed.
	    if (numberOfFloors == 1 || numberOfFloors == 0)
	        return numberOfFloors;
	 
	    // We need k trials for one egg and k floors
	    if (numberOfEggs == 1)
	        return numberOfFloors;
	 
	    int min = Integer.MAX_VALUE, x, res;
	 
	    // Consider all droppings from 1st floor to kth floor and
	    // return the minimum of these values plus 1.
	    for (x = 1; x <= numberOfFloors; x++)
	    {
	        res = Math.max(eggDrop(numberOfEggs-1, x-1), eggDrop(numberOfEggs, numberOfFloors-x));
	        if (res < min)
	            min = res;
	    }
	 
	    return min + 1;
	}
	public static void main(String[] args) {
		int n = 2, k = 5;
	    System.out.println("Minimum number of trials in worst case with "+n+" eggs and "+k+" floors is "+ eggDrop(n, k));		
	}
}

