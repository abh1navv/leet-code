class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0 && nums[i]!=i+1 && nums[i]<nums.length && nums[i]!=nums[nums[i]-1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
                i--;
            }
        }
        //System.out.println()
        
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
            max = Math.max(max, nums[i]);
        }
        
        
        return max+1;
    }
}