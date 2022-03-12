class Solution {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        
        if(amount == 0) return 0;

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        
        dp[0] = 0;
        int div = 0, rem=0;
        for(int i=0; i<coins.length;i++) {
            for(int j=1; j<=amount; j++) {
                if(coins[i] <= j) {
                    dp[j] = Math.min(dp[j], 1+dp[j-coins[i]]);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
    
    
}