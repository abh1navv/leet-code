class Solution {
    public int maxProfit(int[] prices) {
        int[] profitBefore=new int[prices.length];
        
        int min=100001, maxProfit = 0;
        
        for(int i=0; i<prices.length; i++) {
            profitBefore[i] = maxProfit;
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-min);
        }
        
        System.out.println(Arrays.toString(profitBefore));
        
        
        int max=0; maxProfit = 0;

        
        for(int i=prices.length-1; i>=0;i--) {
            max = Math.max(max, prices[i]);
            maxProfit = Math.max(maxProfit, max-prices[i]+profitBefore[i]);
        }
        
        return maxProfit;
    }
}