class Solution {
    public int[] productExceptSelf(int[] nums) {
        int suffix = 1;
        int len = nums.length;
        int[] preffArr = new int[len];
        preffArr[0] = nums[0];
        for(int i=1; i<len; i++) {
            preffArr[i] = preffArr[i-1] * nums[i];
        }
        int product = 1;
        for(int i=len-1; i>0;i--) {
            int temp = nums[i];
            nums[i] = preffArr[i-1]*product;
            product*=temp;
        }
        nums[0] = product;
        
        return nums;
    }
}