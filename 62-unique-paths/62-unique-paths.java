class Solution {
    public int uniquePaths(int m, int n) {
        int[] grid = new int[n];
        for(int i=0;i<n;i++) grid[i] = 1;
        
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                grid[j]+=grid[j-1];
            }
        }
        
        
        return grid[n-1];
    }
    
    
}