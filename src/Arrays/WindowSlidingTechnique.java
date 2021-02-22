package Arrays;

public class WindowSlidingTechnique {

    // Given an array of integers and a number k, find the maximum sum of k consecutive elements.

    public static void main(String[] args) {
        int[] arr = {1,8,30,-5,20,7}; 
        System.out.println(windowSlidingTechinque(arr,3)); // result: 45
    }

    private static int windowSlidingTechinque(int[] arr,int k) {

        int sum = 0;
        for(int i = 0;i<k;i++) {
            sum = sum + arr[i];
        }

        int max = sum;

        for(int i = k; i<arr.length;i++) {
            sum = sum + arr[i] - arr[i-k];

            if(max<sum) {
                max = sum;
            }
        }

        return max;
    }

    


    
}
