package Matrix;

public class RotateMatrixBy90Degrees {

    // rotate matrix 90 degrees anticlockwise

    public static void main(String[] args) {
        int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};

        rotate(mat);
    }
    
    // naive solution
    private static void rotate(int[][] mat) {
        int temp[][] = new int[mat.length][mat.length];

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                temp[i][j] = mat[j][mat.length-1-i];
            }
        }

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }


}
