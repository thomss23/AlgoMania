package Strings;

public class PalindromeCheck {
    
    public static void main(String[] args) {
        String str = "ABCDCBA";

        String str1 = "ABBA";

        String str3 = "geeks";

        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome(str1));
        System.out.println(isPalindrome(str3));

    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
