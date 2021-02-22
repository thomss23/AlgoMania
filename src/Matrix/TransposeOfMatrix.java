package Matrix;

import java.util.Collections;

public class TransposeOfMatrix {
    
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        transpose(arr);
        transposeEff(arr);
    }

    // Naive Solution
    private static void transpose(int[][] arr) {
        int temp[][] = new int[arr.length][arr.length]; 
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                temp[i][j] = arr[j][i];
            }
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                arr[i][j] = temp[i][j];
            }
        }

    }

    // Efficient solution - we just swap the elements without the need of creating another temporary matrix O(1) aux space

    private static void transposeEff(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                int temp  = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;

            }
        }
    }

}
