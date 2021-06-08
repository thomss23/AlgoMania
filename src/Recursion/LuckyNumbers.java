public class LuckyNumbers {
    
    public static void main(String[] args) {
        isLucky(74);
    }

    public static boolean isLucky(int n)
    {
            if(n <= 0 || iteration > n) {
                return true;
            }
            System.out.print("At iteration "  + iteration + " n is : " + n);
            if(n % iteration == 0 ) {
                return false;
            } else {
                int x = iteration;
                iteration = iteration + 1;
                return isLucky(n - n/x);
            }
    }
}
