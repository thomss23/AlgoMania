package BST;

import java.util.TreeSet;

public class CeilingOnLeftSide {

    public static void main(String[] args) {
        System.out.println(5/2);
        ceilLeftSide(new int[]{2, 8, 30, 15, 25, 12});
    }

    private static void ceilLeftSide(int[] arr) {

        TreeSet<Integer> treeSet = new TreeSet<>();

        for(int i = 0; i < arr.length; i++) {
            treeSet.add(arr[i]);
            
            if(treeSet.higher(arr[i]) == null) {
                System.out.print(-1 + " ");
            } else
            System.out.print(treeSet.higher(arr[i]) + " ");
        }
    }

    
}
