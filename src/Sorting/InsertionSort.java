package Sorting;

public class InsertionSort {

    // O(n^2)
    // In-place and stable
    // O(n) in best case

    // Idea is to consider 2 partitions: a sorted partition and an unsorted partiton
    // We take elements from the unsorted partition and we insert them
    // in their correct location in the sorted partition
    // (basically moving all greater elements one position ahead
    // until we find the location for our current element in the loop)



    public static void main(String[] args) {
        int arr[] = {2,10,8,7};

        insertionSort(arr);
        prinArray(arr);
    }

    private static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];

            int j = i - 1;

            while(j>=0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void prinArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
}
