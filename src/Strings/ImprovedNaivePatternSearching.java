package Strings;

// Given a pattern with distinct characters and a text, we need to print all occurrences of the pattern in the text.

public class ImprovedNaivePatternSearching {
    public static void main(String[] args) {
        String txt = "ABCABCDABCD";
        String pat = "ABCD";

        String txt2 = "ABCAAAD";
        String pat2 = "ABD";

        String txt3 = "GEEKSFORGEEKS";
        String pat3 = "EKS";

        naivePatternSearching(txt, pat); // 3 7
        System.out.println();
        naivePatternSearching(txt2, pat2); // nothing
        System.out.println();
        naivePatternSearching(txt3, pat3); // 2 10

    }

    //my solution
    private static void naivePatternSearching(String txt, String pat) {
        int j = 0;
        int startPos = -1;

        for(int i = 0; i < txt.length(); i++) {
            if(txt.charAt(i) != pat.charAt(j)) {
                j = 0;
                startPos = i;
                if(txt.charAt(i) == pat.charAt(j)) {
                    j++;
                }
            } else {
                if (j == pat.length() - 1) {
                    j = 0;
                    System.out.print(startPos + " ");
                    startPos = i+1;
                } else {
                    j++;
                }

            }
        }
    }
    //gfg sol
    static void patSearchinng(String txt,String pat){
        int m=pat.length();
        int n=txt.length();
        for(int i=0;i<=(n-m);  ){
            int j;
            for(j=0;j<m;j++)
            if(pat.charAt(j)!=txt.charAt(i+j))
            break;
            
            if(j==m)
            System.out.print(i+" ");
            if(j==0){
            i++;}
            else{
            i=(i+j);}
        }
        }
    

}
