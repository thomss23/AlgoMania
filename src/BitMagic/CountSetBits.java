package BitMagic;

public class CountSetBits {

    public static void main(String[] args) {

        int n = 5; // binary rep 101
        int count = 0;
        
        for(int i = 1; i <=32; i++) {
            if ((n & (1<<i)) != 0 ) {
                count++;
            }
        }

        System.out.println(count);
        
    }
    // Brian and Kerningham Algorithm O(Set bit count)
    int countSetAlternate(int n) {

        int res = 0;
        
        while(n > 0) {
            n = (n & (n - 1));
            res++;
        }

        return res;

    }


    
}
