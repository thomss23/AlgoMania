package Arrays;

public class PalindromeSubstring {
    public int countSubstrings(String s) {
        
        int count = 0;
        char[] stringToChar = s.toCharArray();

        for(int i = 0; i < stringToChar.length-1; i++) {
            int j = i;
            int k = i;

            while(i>=0 && j<stringToChar.length) {
                if(stringToChar[j]!=stringToChar[k]) {
                    break;
                }
                i++;
                j--;
                count++;

            }
            j=i;
            k=i+1;
            while(i>=0 && j<stringToChar.length) {
                if(stringToChar[j]!=stringToChar[k]) {
                    break;
                }
                i++;
                j--;
                count++;

            }
        }
        return count;
    }
}
