class Solution {
    public void moveZeroes(int[] nums) {
        int lastZero = nums.length;
        for(int i=0;i<lastZero; i++) {
            if(nums[i] == 0) {
                for(int j=i; j<lastZero-1; j++) {
                    nums[j] = nums[j+1];
                }
                nums[--lastZero] = 0;
                i--;
            }
        }
    }
}