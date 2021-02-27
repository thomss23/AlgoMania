package BitMagic;

public class CheckKthBitSetOrNot {
    
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        
        if ((n & (1 << (k - 1))) !=0) 
            System.out.println("Yes");
        else 
            System.out.println("No");
        
    }


}
