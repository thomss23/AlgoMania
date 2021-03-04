package Strings;

public class NaivePatternSearching {
    
    public static void main(String[] args) {
        String txt = "ABABABCD";
        String pat = "ABAB";

        String txt2 = "AAAAA";
        String pat2 = "AAA";

        
        String txt3 = "ABCABCD";
        String pat3 = "ABCD";

        naivePatternSearching(txt, pat);
        System.out.println();
        naivePatternSearching(txt2, pat2);
        System.out.println();
        naivePatternSearching(txt3, pat3);
    }


    //my solution
    private static void naivePatternSearching(String txt, String pat) {
        for(int i = 0; i < txt.length(); i++) {
            int j = 0;
            int k = i;
            while(true) {
                if(pat.charAt(j) != txt.charAt(k) || j == pat.length() - 1 || k == txt.length() - 1 ) {
                    break;
                } else {
                    j++;
                    k++;
                }
                if(j == pat.length() - 1 && txt.charAt(k) == pat.charAt(j)) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    //gfg solution
    static void patSearchinng(String txt,String pat){
        int m=pat.length();
        int n=txt.length();
        for(int i=0;i<=(n-m);i++){
            int j;
            for(j=0;j<m;j++)
            if(pat.charAt(j)!=txt.charAt(i+j))
            break;
            
            if(j==m)
            System.out.print(i+" ");
        }
    }



}
