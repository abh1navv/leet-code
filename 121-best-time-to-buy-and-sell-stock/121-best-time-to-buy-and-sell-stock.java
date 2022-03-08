class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, maxProfit = 0;
        for(int i=prices.length-1; i>=0;i--) {
            max = Math.max(max, prices[i]);
            maxProfit = Math.max(maxProfit, max-prices[i]);
        }
        
        return maxProfit;
    }
}