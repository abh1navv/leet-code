class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        
        if(nums.length < 3) return count;
        
        Arrays.sort(nums);
        int third = nums.length-1, second = nums.length-2, first = nums.length-3; 
        
        while(second > 0) {            
            while(first>=0 && nums[third] < nums[second] + nums[first--]) {
                count++;
            }
            
            second--;
            first = second-1;
            
            if(second == 0) {
                third--;
                second = third - 1;
                first = second - 1;
            }
        }
        
        return count;
    }
}