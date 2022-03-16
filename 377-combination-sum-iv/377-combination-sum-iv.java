class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        //Arrays.fill(dp, 1);
        dp[0] = 1;
        for(int i=1; i<=target; i++) {
            for(int j=0; j<nums.length; j++) {
                if(nums[j] <= i) {
                    //int div = i/nums[j];
                    dp[i] += dp[i-nums[j]];
                } 
            }
            //System.out.println(Arrays.toString(dp));
        }
        
        return dp[target];
    }
}