class Solution {
    public boolean canJump(int[] nums) {
        int maxDist =0;
        for(int i=0; i<nums.length-1; i++) {
            if(i>maxDist) return false;
            if(maxDist >= nums.length-1) return true;
            
            maxDist = Math.max(maxDist, i+nums[i]);
        }
        
        return maxDist >= nums.length-1;
    }
}