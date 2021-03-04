package Strings;

import java.util.Arrays;
import java.util.HashMap;

// Given a string, the task is to find the first character (whose leftmost appearance is first) that repeats.

public class LeftMostRepeatingCharacter {
 
    public static void main(String[] args) {
        String s = "geeksforgeeks";

        String t = "abbcc";

        String z = "abcd";

        System.out.println(findChar(s));

        System.out.println(findChar(t));

        System.out.println(findChar(z));
    }

    private static int findChar(String s) {

        int CHAR = 256;

        int[] count = new int[CHAR];

        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        for(int i = 0; i < s.length(); i++) {
            if(count[s.charAt(i)] > 1) {
                return i;
            }
        }

        return -1;

    }


    static final int CHAR=256;
    static int leftMost(String str) {

    int[] fIndex=new int[CHAR];
    Arrays.fill(fIndex,-1);
    int res=Integer.MAX_VALUE;
    
    for(int i=0;i<str.length();i++){
        int fi=fIndex[str.charAt(i)];
        if(fi==-1)
        fIndex[str.charAt(i)]=i;
        else
        res=Math.min(res,fi);
    }
    
    return (res==Integer.MAX_VALUE)?-1:res;
    } 



}
