class Solution {
    boolean[][] matrix;
    int n;
    public int totalNQueens(int n) {
        matrix = new boolean[n][n];
        this.n=n;
        
        return countWays(0);
    }
    
    int countWays(int row) {        
        int ways=0;
        
        for(int i=0; i<n; i++) {
            if(!matrix[row][i]) {
                if(row == n-1) {
                    ways++;
                } else {
                    boolean[][] copy = copyMatrix();
                    fillMatrix(row, i);
                    ways+=countWays(row+1);
                    matrix=copy;
                }
            }
        }
        return ways;
    }

    
    void fillMatrix(int row, int col) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==row || j==col || Math.abs(i-row)==Math.abs(j-col)) {
                    matrix[i][j] = true;
                }
            }
        }
    }
    
    boolean[][] copyMatrix() {
        boolean[][] copy = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        return copy;
    }
    
}