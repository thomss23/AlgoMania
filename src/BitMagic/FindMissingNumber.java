package BitMagic;

public class FindMissingNumber {
    /*
    Given an array of n numbers that has values in range [1...n+1]. Every number
    appears exactly once. Hence one number is missing. Find the missing number.
    */

    public static void main(String[] args) {
        int[] arr = {1, 4, 3};


        System.out.println(findNumber(arr));
    }

    // O(n)
    private static int findNumber(int[] arr) {
        int a = 1;
        int b = arr[0];

        for(int i = 2; i <= arr.length + 1; i++) {
            a = a ^ i;
        }

        for (int i = 1; i < arr.length; i++) {
            b = b ^ arr[i];
        }

        return a ^ b;
    }
}
