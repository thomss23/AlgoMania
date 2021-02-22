package Recursion;

public class Print1ToNUSingRecursion {

    public static void main(String[] args) {
        // printNums(5);
        printNumsTailRecursive(5, 1);
    }

    private static void printNums(int n) {
        
        if (n == 0) {
            return;
        }
        
        printNums(n - 1);
        System.out.println(n);
    }


    private static void printNumsTailRecursive(int n, int k) {

        if (n == 0) {
            return;
        }

        System.out.println(k);
        printNumsTailRecursive(n - 1, k + 1);

    }
    
}
