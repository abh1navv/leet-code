class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) return 0;
        
        int start = 0, count = 0;
        for(int i=2; i<nums.length; i++) {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                start+= 1;
                count+=start;
            } else {
                start = 0;
            }
        }
                
        return count;
    }
    
}