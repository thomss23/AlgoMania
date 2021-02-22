package Recursion;

public class FactorialAndFibonacci {

    public static void main(String[] args) {
        
        System.out.println(factorial(4));
        System.out.println(fibonacci(4));
        System.out.println(sum(3));
    
    }
    
    private static int factorial(int n) {
        
        if(n == 0 || n == 1) {
            return 1;
        }

        return n*factorial(n - 1);


    }

    private static int fibonacci(int n) {
        
        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return 1;
        }
        
        return fibonacci(n - 2) + fibonacci(n - 1);


    }

    //BONUS : sum of n natural numbers using recursion

    private static int sum(int n) {

        if (n == 0) {
            return 0;
        }

        return n + sum(n - 1);
    }

}
