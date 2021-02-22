package Searching;

public class AllocateMinimumPages {

    /*
    Ex: [10,20,10,30] k = 2
    Sum of all pages = 10 + 20 + 10 + 30 = 70
    Answer will be in range [30, 70]
    First we start with x = (30 + 70) / 2


    */

    public static void main(String[] args) {
        int[] arr = {10,20,10,30};
        int k = 2;


        System.out.println(allocateMinPages(arr, k));
    }

    private static int allocateMinPages(int[] arr, int k) {
        int sum = 0;
        int mx = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            mx = Math.max(mx,arr[i]);
        }

        int low = mx;
        int high = sum;
        int res = 0;
        
        while(low <=high) {
            int mid = (low + high) / 2;
            if (isFeasible(arr,arr.length, k, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private static boolean isFeasible(int[] arr, int n, int k, int ans) {
        int req = 1;
        int sum = 0;
        
        for(int i = 0; i < n; i++) {
            if(sum + arr[i] > ans) {
                req++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return req <= k;
    }
    
}
