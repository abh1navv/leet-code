class Solution {
    public boolean canJump(int[] nums) {
        nums[nums.length-1] = -1;
        for(int i=nums.length-2; i>=0; i--) {
            for(int j=i; j<=Math.min(i+nums[i], nums.length-1) ; j++) {
                if(nums[j] == -1) {
                    nums[i] = -1;
                }
            }
        }
        
        return nums[0] == -1;
    }
}