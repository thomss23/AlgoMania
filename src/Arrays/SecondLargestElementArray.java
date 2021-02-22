package Arrays;

public class SecondLargestElementArray {
    
    public static void main(String[] args) {
        int[] arr1 = {10,20,100,5,8,50};
        int[] arr2 = {10,10,10,10,10,2};
        System.out.println(getSecondLargestNaive(arr1));
        System.out.println(getSecondLargestOneTraversal(arr1));
        
    }

    public static int getSecondLargestNaive(int[] arr) {

        int max1 = 0;
        int max2 = -1;

        for(int i = 1 ;i<arr.length;i++) {
            if(arr[i] > arr[max1]) {
                max1 = i;
            }
        }

        for(int i = 0 ;i<arr.length;i++) {
           if(arr[i]!=arr[max1]) {
                if(max2==-1)
                    max2 = i;
                else if(arr[i]>arr[max2]) {
                    max2=i;
                }
           }

        }

        return max2;

    }

    public static int getSecondLargestOneTraversal(int[] arr) {

        int max1 = 0;
        int max2 = -1;

        for(int i=2;i<arr.length;i++) {
            if(arr[i]>arr[max1]) {
                max2 = max1;
                max1 = i;
            } else if(arr[i]!=arr[max1]) {
                if(max2==-1 || arr[i]>arr[max2]) {
                    max2=i;
                }
            }   
        }
        return max2;

    }













}
