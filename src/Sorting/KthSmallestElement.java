package Sorting;


public class KthSmallestElement {
    
    public static void main(String[] args) {
        int[] arr = {3,5,4,2,9}; //output should be 4
        int k = 3;
        int n = 5;
        
       System.out.println(arr[kthSmallest(arr, n, k)]);
    }

    private static int kthSmallest(int[] arr, int n, int k) {

        int low = 0;
        int high = n - 1;


        while(low <= high) {
            int p = partition(arr, low, high);
            if(p==k-1)
                return p;
            else if(p>k-1)
                high=p-1;
            else
                low=p+1;

        }

        return -1;


    }

    static int partition(int arr[], int l, int h)
    {   
        int pivot=arr[h];
        int i=l-1;
        for(int j=l;j<=h-1;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[h];
        arr[h]=temp;
        return i+1;
    }

}
