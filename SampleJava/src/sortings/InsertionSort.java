package sortings;

import java.util.Arrays;

public class InsertionSort {
	 private void insertionSort(int arr[])
	 {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
	 }
	 public static void main(String Args[])
	 {
		 int[] arr = {1,5,6,7,3,90,32,77};
		System.out.println(Arrays.toString(arr));
		InsertionSort ss = new InsertionSort();
		ss.insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	 }
}
