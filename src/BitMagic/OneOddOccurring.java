package BitMagic;

public class OneOddOccurring {
    
    // This program takes an array of integers and displays the number that has odd occurrences in the array.

    public static void main(String[] args) {
        int[] arr = {4,3,4,4,4,5,5};

        System.out.println(findOddOne(arr));
    }

    private static int findOddOne(int[] arr) {

        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        return res;
    }   

}
