package Arrays;

public class MaximumDifference {
    
    //Maximum Difference problem is to find the maximum of arr[j] - arr[i] where j>i.
    public static void main(String[] args) {
        int[] a = {2,3,10,6,4,8,1};
        System.out.println(maxDif(a)); 
    }


    //O(n)
    private static int maxDif(int[] a) {

        int result = a[1]-a[0];
        int minval = a[0];

        for(int j=1;j<a.length;j++) {
            result = max(result,a[j]-minval);
            minval = min(minval,a[j]);
        }

        return result;
    }

    private static int min(int minval, int i) {
        if(minval<i) {
            return minval;
        } 
        return i;
    }

    private static int max(int result, int i) {
        if(result>i)
            return result;
        return i;
    }

 

}
