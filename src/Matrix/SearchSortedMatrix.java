package Matrix;

public class SearchSortedMatrix {

    // Search an element in a row-wise and column-wise sorted matrix. 
    // Should be O(r+c) time complexity

    // Tricky problem. Explanation:
    // 1) Begin from the top right corner
    // 2) if x == current element, print position and return
    // 3) if x is smaller, move left
    // 4) if x is greater, move down

    public static void main(String[] args) {
        int[][] mat = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};

        search(mat, 4, 4, 11);
    }

    private static void search(int[][] mat, int r, int c, int x) {
        int i = 0;
        int j = c - 1;
        boolean found = false;

        while(i < r && j >= 0) {
            if(mat[i][j] == x) {
                System.out.println("Found at pos " + i + " " + j);
                found = true;
            }
            if(x < mat[i][j]) {
                j--;
            } else {
                i++;
            }
        }

        if(!found) {
            System.out.println("Not Found");
        }

    }
    
}
