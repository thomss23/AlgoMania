package Sorting;

public class SortAnArrayWithTwoTypesOfElements {

    public static void main(String[] args) {
        int[] arr = {15, -3, -2, 18,7,-34,3,-6,2,66,-4,-5,-2};
        sort(arr, 0, 12);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void sort(int[] arr, int l, int h) {
        
        if(l < h) {
            int p = partiton(arr,l,h);
            sort(arr, l, p - 1);
            sort(arr, p + 1, h);
        }

    }

    private static int partiton(int[] arr, int l, int h) {
        int i = l - 1;

        for(int j = l; j <= h-1; j++) {
            if(arr[j] < 0 && arr[h] > 0) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }

        }
        int temp=arr[i+1];
        arr[i+1]=arr[h];
        arr[h]=temp;
        return i+1;
    }
    
}
