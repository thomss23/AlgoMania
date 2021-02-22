package Recursion;

public class RopeCuttingProblem {

    public static void main(String[] args) {
        
        System.out.println(ropeCutting(23, 11, 9, 12));
    }

    private static int ropeCutting(int n,int a, int b, int c) {

        if(n == 0) {
            return 0;
        }

        if(n < 0) {
            return -1;
        }

        int res = max(ropeCutting(n-a,a,b,c), ropeCutting(n-b, a, b, c), ropeCutting(n-c, a, b, c));

        if (res == -1) {
            return -1;
        }

        return res + 1;
    }

    private static int max(int a, int b,int c) {
        if (a>b && a>c) {
            return a;
        } else if(b>a && b>c) {
            return b;
        }
        else {
            return c;
        }
    }


    
}
