package Sorting;

public class UnionOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] a = {3,5,8};
        int[] b = {2,8,9,10,15};

        int[] a1 = {2,3,3,3,4,4};
        int[] b1 = {4,4};

        union(a,b);
        System.out.print("\n");
        union(a1, b1);

    }

    private static void union(int[] a, int[] b) {
        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            
            if(i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }

            if (j > 0 && b[j] == b[j - 1] ) {
                j++;
                continue;
            }

            if (a[i] < b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else if(a[i] > b[j]) { 
                System.out.print(b[j] + " ");
                j++;
            } else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
        
        while (i < a.length) {

            if(a[i] != a[i-1])
                System.out.print(a[i] + " ");
            i++;

        }

        while (j < b.length) {
            if(b[j] != b[j-1])
                System.out.print(b[j] + " ");
            j++;
        }


    }  
    
}
