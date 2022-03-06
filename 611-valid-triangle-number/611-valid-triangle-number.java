class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        
        if(nums.length < 3) return count;
        
        Arrays.sort(nums);
        int third = nums.length-1; 
        
        while(third > 1) {            
            count += twoSum(nums[third], nums, 0, third-1);
            third--;
        }
        
        return count;
    }
    
    int twoSum(int target, int[] nums, int start, int end) {
        int valid = 0;
        while(start<end) {
            if(nums[start]+nums[end] > target) {
                valid+=end-start;
                end--;
            } else {
                start++;
            } 
        }
        return valid;
    }

}