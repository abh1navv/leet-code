class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<Integer>();
        Arrays.stream(days).forEach(i->set.add(i));
        
        int[] dp=new int[366];
        //Arrays.fill(dp, 367);
        
        for(int i=1; i<366; i++) {
            if(set.contains(i)) {
                dp[i] = Math.min(Math.min(dp[i-1] + costs[0],
                                dp[Math.max(0, i-7)] + costs[1]),
                                 dp[Math.max(0, i-30)] + costs[2]);
            } else {
                dp[i] = dp[i-1];
            }
        }
        
        return dp[365];
        
    }
}