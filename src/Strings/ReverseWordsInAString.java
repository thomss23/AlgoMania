package Strings;

import java.util.Stack;

public class ReverseWordsInAString {
    
    public static void main(String[] args) {
       String str = "Welcome to gfg"; 

       reverseWords(str);
       reverseWordsAlternativeSol(str);
    }

    private static void reverseWords(String s) {

        Stack<String> st = new Stack<>();
        String temp = "";

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                st.add(temp);

                temp = "";
            } else {
                temp = temp + s.charAt(i);
            }
        }

        st.add(temp); // adding last word left out of the loop

        while(!st.empty()) {
            System.out.print(st.pop() + " ");
        }


    }

    // another solution is to reverse every word then reverse the entire string

    private static void reverseWordsAlternativeSol(String s) {

        int start = 0;
        int end = 0;

        while(end < s.length()) {
            if(s.charAt(end) == ' ') {
                reverse(s, start, end);
                start = end + 1;
            }
        }

        reverse(s, 0, s.length()-1);
        System.out.println(s);

    }

    private static void reverse(String s, int i, int j) {
        while(i <= j) {
            swap(s.charAt(i), s.charAt(j));
            i++;
            j--;
        }
    }

    private static void swap(char a, char b) {
        char temp = a;
        a = b;
        b = temp;
    }

}
