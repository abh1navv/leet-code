class Solution {
    int[][] matrix;
    int[][] swapMatrix;
    int[][] temp;
    int n;
    public int totalNQueens(int n) {
        matrix = new int[n][n];
        swapMatrix = new int[n][n];

        this.n=n;
        return countWays(0, -2);
    }
    
    int countWays(int row, int prev) {        
        int ways=0;
        
        for(int i=0; i<n; i++) {
            if(matrix[row][i]==0) {
                if(row == n-1) {
                    ways++;
                } else {
                    int[][] copy = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
                    fillMatrix(row, i, 1);
                    ways+=countWays(row+1, i);
                    matrix=copy;
                }
            }
        }
        return ways;
    }

    
    void fillMatrix(int row, int col, int val) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==row || j==col || Math.abs(i-row)==Math.abs(j-col)) {
                    matrix[i][j] = val;
                }
            }
        }
    }
    
}