package BitMagic;

public class PowerOfTwo {

    // Program to check whether a number is a power of 2 or not.

    public static void main(String[] args) {
        
        int n = 16;
        if (n ==  0) 
            System.out.println("Number is not power of 2");

        n = (n & (n - 1)); 

        if (n == 0) {
            System.out.println("Number is power of 2");
        } else {
            System.out.println("Number is not power of 2");
        }



    }
    
}
