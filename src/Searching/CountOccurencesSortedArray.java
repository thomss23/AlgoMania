package Searching;

public class CountOccurencesSortedArray {

    // Given a sorted array and an element x, we need to count occurrences of x in the array.

    public static void main(String[] args) {
        int[] arr = {10,20,20,20,30,30,40};
        System.out.println(countOccurences(arr, 20)); // should return 4

    }

    private static int countOccurences(int[] arr , int x) {

        int posLeft = -1;
        int posRight = -1;
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {

            int mid = (low + high) / 2;

            if(mid == 0 || arr[mid-1] != arr[mid]) {
                posLeft = mid;
                break;
            } else {
                high = mid - 1;
            }

            if(arr[mid] > x) {
                high = mid - 1;
            }
            
            if(arr[mid] < x) {
                low = mid + 1;
            }
        }


        low = 0;
        high = arr.length - 1;

        while(low <= high) {

            int mid = (low + high) / 2;

            if(mid == arr.length-1 || arr[mid + 1] != arr[mid]) {
                posRight = mid;
                break;
            } else {
                low = mid + 1;
            }

            if(arr[mid] > x) {
                high = mid - 1;
            }
            
            if(arr[mid] < x) {
                low = mid + 1;
            }

        }

        if(posLeft == -1) {
            return -1;
        }

        return posRight - posLeft + 1;
        

    }



}
