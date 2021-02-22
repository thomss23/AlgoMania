package Searching;

public class IndexOfFirstOccurence {

    // Given a sorted array with repetition and an element x, we need to find index of first occurrence of x.

    public static void main(String[] args) {
        
        int[] arr = {10,10,10};
        System.out.println(firstOccurence(arr, 10)); // should return 4
    }

    private static int firstOccurence(int[] arr, int x) {

        int low = 0;
        int high = arr.length - 1;
        int found = -1;

        while(low <= high) {

            int mid = (low + high) / 2;

            // if(arr[mid] != x && found != -1) {
            //     return found;
            // }

            // if(arr[mid] == x) {
            //     found = mid;
            //     high = mid - 1;
            // }

            //or 

            if(mid == 0 || arr[mid-1] != arr[mid]) {
                return mid;
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

        return -1;


    }
    
}
