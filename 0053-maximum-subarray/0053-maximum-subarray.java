class Solution {
    
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxEndingHere = nums[0];
        for(int i=1; i< nums.length; i++) {
            maxEndingHere = Math.max(nums[i], nums[i] + maxEndingHere);
            max = Math.max(max, maxEndingHere);
        }
        return max;
    }
    
    
    
    
}