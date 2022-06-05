class Solution {
    int[][] matrix;
    int n;
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        matrix = new int[n][n];
        this.n=n;
        countWays(0);
        return ans;
    }
    
    int countWays(int row) {        
        int ways=0;
        
        for(int i=0; i<n; i++) {
            if(matrix[row][i] == 0) {
                if(row == n-1) {
                    matrix[row][i] += 10+row;
                    ans.add(getWay());
                    ways++;
                    matrix[row][i] -= 10+row;
                } else {
                    int[][] copy = copyMatrix();
                    fillMatrix(row, i);
                    matrix[row][i] += 10+row;
                    ways+=countWays(row+1);
                    matrix=copy;
                }
            }
        }
        return ways;
    }
    
    List<String> getWay() {
        List<String> way = new ArrayList<>();
        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++) {
                if(matrix[i][j] >= 10) {
                   sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            way.add(sb.toString());
        }
        return way;
    }

    
    void fillMatrix(int row, int col) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==row || j==col || Math.abs(i-row)==Math.abs(j-col)) {
                    matrix[i][j] = 1;
                }
            }
        }
    }
    
    int[][] copyMatrix() {
        int[][] copy = new int[n][n];
        for(int i=0; i<n; i++) {
            copy[i] = matrix[i].clone();
        }
        return copy;
    }
    

}