package Searching;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {10,20,30,40,50,60,70};
        // int[] arr = {10};
        System.out.println(binarySearch(arr, 10));
        System.out.println(bSearchRec(arr, 0, arr.length - 1, 10));

    }

    private static int binarySearch(int[] arr,int x) {
        int low = 0;
        int high = arr.length-1;

        while(low<=high) {

            int mid = (low+high)/2;

            if(arr[mid] == x) {
                return mid;
            }
    
            if(arr[mid] > x) {
                high = mid-1;
            } 
    
            if(arr[mid] < x) {
                low = mid+1;
            }

        }

        return -1;
    }

    static int bSearchRec(int arr[], int low, int high, int x)
	{
		if(low > high)
			return -1;

		int mid = (low + high) / 2;

		if(arr[mid] == x)
			return mid;

		else if(arr[mid] > x)
			return bSearchRec(arr, low, mid - 1, x);

		else
			return bSearchRec(arr, mid + 1, high, x);
	}


    
}
