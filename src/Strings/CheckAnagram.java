package Strings;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagram {
    
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        String s3 = "aab";
        String s4 = "bab";

        System.out.println(isAnagram(s1, s2)); //true
        System.out.println(isAnagram(s3, s4)); //false
    }

    private static boolean isAnagram(String s, String t) {
        
        HashMap<Character, Integer> map = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0 ; i < t.length(); i++) {
            if(!map.containsKey(t.charAt(i))){ 
                return false;
            }
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }

        for(Map.Entry entry : map.entrySet()) {
            if((Integer) entry.getValue() != 0) {
                return false;
            }
        }

        return true;

    }


    static final int CHAR=256;
        
    static boolean areAnagram(String s1, String s2) { 
       
        if (s1.length() != s2.length()) 
            return false; 
  
    int[] count=new int[CHAR];

    for(int i=0;i<s1.length();i++){
        count[s1.charAt(i)]++;
        count[s2.charAt(i)]--;
    }
    
    for(int i=0;i<CHAR;i++){
        if(count[i]!=0)
            return false;
    }

    return true;
    } 

}
