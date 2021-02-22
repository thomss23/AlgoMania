package Arrays;

public class MaximumConsecutive1sBinaryArray {

    public static void main(String[] args) {
        int[] arr = {0,1,1,0,1,1,0,0,1,1,1,0,0,1,0,1,1,1,1};
        System.out.println(maxConsec(arr));
    }

    //O(n)
    private static int maxConsec(int[] arr) {
        int max=0;
        int tempCount=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==1) {
                tempCount++;
            } else if(arr[i]==0) {
                if(max<tempCount) {
                    max=tempCount;
                }
                tempCount = 0;
            }
            if(i==arr.length-1) {
                if(max<tempCount) {
                    max=tempCount;
                }
            }
        }
        return max;
    }
    
}
