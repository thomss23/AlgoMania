package BitMagic;

public class TwoOddOccurring {
    
    // This program takes an array of integers and displays the two numbers that have odd occurrences in the array.

    public static void main(String[] args) {

        int[] arr = {3,4,3,4,5,4,4,6,7,7};

        findNumbers(arr, arr.length);
    }

    private static void findNumbers(int[] arr, int n ) {

        int xor = 0, res1 = 0, res2 = 0; 
        
        for (int i = 0; i < n; i++) 
        xor = xor ^ arr[i]; 
  
        int sn = xor & (~(xor - 1)); //rightmost set bit
  
        for (int i = 0; i < n; i++) {
         
            if ((arr[i] & sn) != 0) 
                res1 = res1 ^ arr[i]; 
            else
                res2 = res2 ^ arr[i]; 
        } 
        
        
        System.out.println( res1 + " " + res2);
        
    }

}
