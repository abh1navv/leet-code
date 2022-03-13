class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] other = Arrays.stream(nums).sorted().toArray();
        int len = other.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        int prev, prevLeft;
        for(int i=0; i< len; i++) {
            prev = 0;
            prevLeft = 0;
            for(int j=0; j<len;j++) {
                prevLeft = prev;
                prev = dp[j+1];
                if((j==0 || nums[i] != other[j-1]) && nums[i] == other[j]) {
                    dp[j+1] = 1+prevLeft;
                } else {
                    dp[j+1] = Math.max(prev, dp[j]);
                }
            }
        }
        
        return dp[len];
    }
}