package Searching;

// Majority element is an element that appears more than n/2 times in an array of size n (Moore's Voting Algorithm)

public class MajorityElement {
    
    public static void main(String[] args) {
        
    }

    int findMajority(int[] arr, int n) {
        int res = 0;
        int count = 1;

        for(int i = 1; i < n; i++) {
            if(arr[res] == arr[i]) {
                count++;
            } else {
                count--;
            }
            if(count == 0) {
                res = i;
                count = 1;
            }
        }

        count = 0;
        for(int i = 0; i < n; i++) {
            if(arr[res] == arr[i]) {
                count++;
            }
        }
        if(count <= n/2) {
            res = -1;
        }

        return res;
    }

}
