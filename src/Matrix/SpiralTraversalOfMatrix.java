package Matrix;

public class SpiralTraversalOfMatrix {

    public static void main(String[] args) {
        int mat[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        int mat2[][] = {{1,2,3},{4,5,6}};

        int mat3[][] = {{10,20,30}};

        int mat4[][] = {{10},{20},{30}};

        int mat5[][] = {{6,6,2,28,2}, {12,26,3,28,7},{22,25,3,4,23}};

        // spiralTraversal(mat, 4, 4);
        // System.out.println();
        // spiralTraversal(mat2, 2, 3);
        // System.out.println();
        // spiralTraversal(mat3, 1, 3);
        // System.out.println();
        // spiralTraversal(mat4, 3, 1);
        // System.out.println();
        spiralTraversal(mat5, 3, 5);
    }

    private static void spiralTraversal(int[][] mat, int n, int m) {
        int left  = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;
        int i;

        if(n == 1) {
            for(i = 0;i < m; i++) {
                System.out.print(mat[0][i] + " ");
            }
        } else if(m == 1) { 
            for(i = 0; i < n; i++) {
                System.out.print(mat[i][0] + " ");
            }
        }
        else {
            while(left <= right && top <= bottom) {

                for(i = left;i <= right; i++) {
                    System.out.print(mat[top][i] + " ");
                }
                top++;
                
                System.out.println("\n=======");
    
                for(i = top; i <= bottom; i++) {
                    System.out.print(mat[i][right] + " ");
                }
                right--;
                System.out.println("\n=======");

                if(top<=bottom) {
                for(i = right; i >= left; i--) {
                    System.out.print(mat[bottom][i] + " ");
                }
                bottom--;
                }   
                System.out.println("\n=======");
                
                if(left<=right) {
                for(i = bottom; i >= top; i--) {
                    System.out.print(mat[i][left] + " ");
                }
                System.out.println("\n=======");
                left--;
                }
                
            } 
        }
        
    }
    
}
