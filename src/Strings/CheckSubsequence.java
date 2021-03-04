package Strings;

public class CheckSubsequence {

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "AD";

        String s3 = "ABCDE";
        String s4 = "AED";

        System.out.println(isSubsequence(s1, s2)); //true

        System.out.println(isSubsequence(s3, s4)); //false

        System.out.println(isSubsequenceRec(s1, s2,0,0)); //true

        System.out.println(isSubsequenceRec(s3, s4,0,0)); //false
    }

    private static boolean isSubsequence(String s1, String s2) {
        int i = 0;
        int j = 0;

        while(i < s1.length() - 1 && j < s2.length() - 1 ) {
            if(s1.charAt(i) != s2.charAt(j)) {
                i++;
            } else {
                i++;
                j++;
            }
        }

        return j == s2.length() - 1;
    }
    // start with i = 0 and j = 0
    private static boolean isSubsequenceRec(String s1, String s2,int i, int j) {

        if(j == s2.length() - 1) {
            return true;
        } 
        if(i == s1.length() - 1) {
            return false;
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            return isSubsequenceRec(s1, s2, i+1, j+1);
        } else {
            return isSubsequenceRec(s1, s2, i+1, j);
        }





    }



    
}
