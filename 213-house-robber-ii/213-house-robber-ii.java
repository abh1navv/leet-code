class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];   
        if(nums.length == 1) return nums[0];
        dp[1] = nums[1];        
        
        for(int i=2; i<nums.length;i++) {
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        int max1 = dp[nums.length-1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);        
        
        for(int i=2; i<nums.length-1;i++) {
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return Math.max(max1 , dp[nums.length-2]);
    }
}