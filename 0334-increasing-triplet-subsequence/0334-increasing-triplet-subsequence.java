class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;
        
        int low1 = Integer.MAX_VALUE;
        int low2 = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length;i++) {
            if(nums[i] <= low1) low1 = nums[i];
            else if(nums[i] <=low2) low2 = nums[i];
            else return true;
        }
        
        return false;
    }
}