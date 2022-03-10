class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int index = 0;

        for(int i=0;i<len; i++) {
            if(nums[i] != 0) {
                nums[index++] = nums[i]; 
            }
        }
        
        while(index != len) {
            nums[index++] = 0;
        }
    }
}