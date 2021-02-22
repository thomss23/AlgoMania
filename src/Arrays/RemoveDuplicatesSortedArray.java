package Arrays;

public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {
        int[] arr = {10,20,20,30,30,30,30}; 
        System.out.println(removeDuplicatesBad(arr)); 
        System.out.println(removeDuplicatesEfficient(arr)); 
    }

    public static int removeDuplicatesBad(int[] arr) {
        int size = arr.length-1;
        for(int i=0;i<size;i++) {
            if(arr[i]==arr[i+1]) {
                for(int j=i;j<size;j++) {
                    arr[j] = arr[j+1];
                }
                size--;
            }
        }
        return size;
    }

    public static int removeDuplicatesEfficient(int[] arr) {
        int res = 1;
        for(int i=1;i<arr.length;i++) {
            if(arr[i]!=arr[res-1]) {
                arr[res] = arr[i];
                res++;
            }
        }
        return res;
    }


    
}
