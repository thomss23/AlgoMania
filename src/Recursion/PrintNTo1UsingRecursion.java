package Recursion;

public class PrintNTo1UsingRecursion {

    public static void main(String[] args) {
        printNumbers(5);
    }

    private static void printNumbers(int n) {
        if(n==0) {
            return;
        }
        System.out.println(n);
        printNumbers(n-1);
    }
    
}
