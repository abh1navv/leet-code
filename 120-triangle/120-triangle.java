class Solution {
    Map<String, Integer> cache = new HashMap<>();
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int cols = triangle.get(rows-1).size();
        int[][] dp = new int[rows][cols];
        int min = 10000;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<triangle.get(i).size();j++) {
                dp[i][j] = triangle.get(i).get(j);
            }
        }
        
        
        for(int i=1;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(j >= triangle.get(i-1).size()) {
                    int first = j>0 ? dp[i-1][j-1] : 0;
                    dp[i][j] += first;
                } else {
                    int first = j>0 ? dp[i-1][j-1] : 10000;
                    int second = dp[i-1][j];
                    dp[i][j] += Math.min(first, second);
                }              
                
                if(i == rows-1) {
                    min = Math.min(min, dp[i][j]);
                }
            }
        }
        
        return min == 10000 ? dp[0][0] : min ;
    }
    
}   