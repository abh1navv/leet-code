class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, maxPos=-1, minPos=-1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxPos = i;
            }
            
            if(nums[i] < min) {
                min = nums[i];
                minPos = i;
            }
        }
        int straightPos = Math.max(minPos, maxPos);
        int reversePos = nums.length-straightPos + Math.min(minPos, maxPos);
        
        
        return Math.min(Math.min(straightPos, reversePos) + 1, nums.length-Math.min(minPos, maxPos));
    }
}