package Searching;

// Given an infinite sized array, we need to write an efficient solution to search an element.

public class SearchInfiniteSizedArray {


    public static void main(String[] args) {
        int[] arr = {10,200,300,350,430,500,2000,33414,34144444,341444441,341444441,341444441,341444441,341444441,341444442,341444442,341444443};

        System.out.println(searchInfiniteArr(arr, 33414));
    }



private static int searchInfiniteArr(int[] arr, int x) {
   int pos = 1;
   while (x < arr[pos]) {
    pos = pos * 2;
  }
    int low = pos / 2 + 1;
    int high = pos - 1;
    if(arr[pos] == x) {
        return pos;
    }
    while(low<=high) {

        int mid = (low + high) / 2;

        if(arr[mid] == x) {
            return mid;
        }

        if(arr[mid] > x) {
            high = mid -1;
        }

        if(arr[mid] < x) {
            low = mid + 1;
        }

    }
    return -1;

}

}


