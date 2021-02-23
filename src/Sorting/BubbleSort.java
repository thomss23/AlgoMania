package Sorting;

public class BubbleSort {

    // Stable algorithm
    // O(n^2)
    
    // Idea is to push to max value to the n - 1 position
    // then push second maximum to n - 2 position
    // this is done by swapping consecutive elements n - 1 times
    // until the array is sorted

    public static void main(String[] args) {
        int arr[] = {2,10,8,7};

        bubbleSort(arr);
        prinArray(arr);
    }

    private static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length-1;i++) {
            for(int j = 0; j < arr.length-1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
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
