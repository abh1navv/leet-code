class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for(int i=0; i<len;i++) {
            if(nums[i] == val) {
                nums[i] = nums[len-1];
                i--;
                len--;
            }
        }
        return len;
    }
}