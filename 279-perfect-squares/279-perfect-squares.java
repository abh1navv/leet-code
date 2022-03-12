class Solution {

    public int numSquares(int n) {
        int max = (int)Math.sqrt(n);
        
        int[] dp=new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        
        for(int i=1;i<=max;i++) {
            for(int j=1;j<=n;j++) {
                if(i*i <= j) {
                    dp[j] = Math.min(1+dp[j-i*i], dp[j]);
                }
            }
        }
        
        return dp[n];
    }
    
}