class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int max = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, countAndDrown(grid, i, j, m ,n));
                }
            }
        }
        
        return max;
    }
    
    int countAndDrown(int[][] grid, int i, int j, int m, int n) {
        if(i>m-1 || i<0 || j<0 || j>n-1 || grid[i][j] == 0) return 0;
        int count = 1;
        grid[i][j] = 0;
        
        
        count+=countAndDrown(grid, i+1, j, m ,n);
        count+=countAndDrown(grid, i, j+1, m ,n);
        count+=countAndDrown(grid, i-1, j, m ,n);
        count+=countAndDrown(grid, i, j-1, m ,n);
        
        return count;
    }
}