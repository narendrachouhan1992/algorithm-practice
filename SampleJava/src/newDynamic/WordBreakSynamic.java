package newDynamic;

public class WordBreakSynamic {
	static boolean dictionaryContains(String word)
	{
	    String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
	                           "icecream","and","go","i","like","ice","cream"};
	    int size = dictionary.length;
	    for (int i = 0; i < size; i++)
	        if (dictionary[i].equals(word))
	           return true;
	    return false;
	}
	 
	// Returns true if string can be segmented into space separated
	// words, otherwise returns false
	static boolean canBeDevided(String str)
	{
	    int size = str.length();
	    if (size == 0)   return true;
	 
	    // Create the DP table to store results of subroblems. The value wb[i]
	    // will be true if str[0..i-1] can be segmented into dictionary words,
	    // otherwise false.
	    boolean[] wb = new boolean[size+1];
	   
	    for (int i=1; i<=size; i++)
	    {
	        // if wb[i] is false, then check if current prefix can make it true.
	        // Current prefix is "str.substr(0, i)"
	        if (wb[i] == false && dictionaryContains( str.substring(0, i) ))
	            wb[i] = true;
	 
	        // wb[i] is true, then check for all substrings starting from
	        // (i+1)th character and store their results.
	        if (wb[i] == true)
	        {
	            // If we reached the last prefix
	            if (i == size)
	                return true;
	 
	            for (int j = i+1; j <= size; j++)
	            {
	                // Update wb[j] if it is false and can be updated
	                // Note the parameter passed to dictionaryContains() is
	                // substring starting from index 'i' and length 'j-i'
	                if (wb[j] == false && dictionaryContains( str.substring(i, j-i) ))
	                    wb[j] = true;
	 
	                // If we reached the last character
	                if (j == size && wb[j] == true)
	                    return true;
	            }
	        }
	    }
	 
	    return false;
	}

	public static void main(String[] args) {
		if (canBeDevided("ilikesamsung")) {
			System.out.println("yes");
		} else {
			System.out.println("No");
		}
		if (canBeDevided("iiiiiiii")) {
			System.out.println("yes");
		} else {
			System.out.println("No");
		}
		if (canBeDevided("")) {
			System.out.println("yes");
		} else {
			System.out.println("No");
		}
		if (canBeDevided("ilikelikeimangoiii")) {
			System.out.println("yes");
		} else {
			System.out.println("No");
		}
		if (canBeDevided("samsungandmango")) {
			System.out.println("yes");
		} else {
			System.out.println("No");
		}
		if (canBeDevided("samsungandmangok")) {
			System.out.println("yes");
		} else {
			System.out.println("No");
		}
	}
}
