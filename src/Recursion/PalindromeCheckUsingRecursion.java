package Recursion;

public class PalindromeCheckUsingRecursion {

    public static void main(String[] args) {

        System.out.println(palindrome("ama", 0, "ama".length()-1));
    }

    //pass i=1, k=n-1
    private static boolean palindrome(String s, int i, int k) {
        
        if (i >= k) {
            return true;
        }

        if (s.charAt(i) != s.charAt(k)) {
            return false;
        } else {
            return palindrome(s, i+1, k-1);
        }
    }
}
