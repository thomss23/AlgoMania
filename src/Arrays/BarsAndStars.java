package Arrays;

import java.util.ArrayList;
import java.util.List;

public class BarsAndStars {

    public static void main(String[] args) throws Exception {
        System.out.println(starsAndBars("|**|*|*", new int[] {1,1}, new int[] {5,6})); 
        // raspuns corect [2,3]
    }


    public static List<Integer> starsAndBars(String s, int[] startIndex, int[] endIndex) {
        char[] strArr = s.toCharArray();
        ArrayList<Integer> result = new ArrayList<>();


        int count = 0;

        for(int k=0;k<startIndex.length;k++) {
            
            int start = startIndex[k]-1;
            int  end = endIndex[k]-1;
            int barPos1 = -1;
            int barPos2 = -1;

            for (int i = start; i <= end; i++) {
                if (strArr[i]=='|' && barPos1 == -1 && barPos2 == -1) {
                    barPos1 = i;
                } else if (strArr[i]=='|' && barPos1 != -1 && barPos2 == -1){
                    barPos2=i;
                }
                if (barPos1 != -1 && barPos2 != -1) {
                    for (int j = barPos1 + 1; j < barPos2; j++) {
                        count++;
                    }
                    barPos1 = barPos2;
                    barPos2 = -1;
                }
            }
            result.add(count);
            count = 0;
        }
        return result;
    }   

}
