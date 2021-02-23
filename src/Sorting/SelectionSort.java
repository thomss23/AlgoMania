package Sorting;

public class SelectionSort {

    // Not stable
    // O(n^2)
    // In place algorithm
    
    // Idea is to find first minimum value and place it 
    // on the first postion
    // then find second minimum value and place it on the second
    // position and so on and so forth until the array
    // is sorted

    public static void main(String[] args) {
        int arr[] = {2,10,8,7,5};
        
        selectionSort(arr);
        prinArray(arr);

    }

    private static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    private static void prinArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
