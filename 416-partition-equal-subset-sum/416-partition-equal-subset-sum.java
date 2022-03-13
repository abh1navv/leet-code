class Solution {
    public boolean canPartition(int[] nums) {
        int sum = IntStream.of(nums).reduce((a,b)->a+b).getAsInt();
        int len = nums.length;
        
        if(sum%2==1) return false;
        
        sum = sum/2;

        boolean dp[]=new boolean[sum+1];
        dp[0] = true;
        
        for(int i=0; i<nums.length;i++) {
            for(int j=sum; j>0; j--) {
                if(nums[i] <= j) {
                    dp[j] = dp[j] || dp[j-nums[i]];
                }
            }
        }
        return dp[sum];
    }
    
}