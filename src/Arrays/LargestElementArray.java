package Arrays;

public class LargestElementArray {

    public static void main(String[] args) {
        int[] arr = {10,20,100,5,8};
        int max = 0;
        int pos = 0;
        for(int i =0 ; i<arr.length;i++) {
            if(arr[i]>max) {
                max = arr[i];
                pos = i;
            }
        }

        System.out.println("pos is " + pos);
        
    }
}
