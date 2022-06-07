class Solution {
    public int[] shuffle(int[] nums, int n) {
        if(nums.length <= 2) return nums;
        int[] ans = new int[2*n]; 
        int index = 0;
        for(int i=0; i<n; i++) {
            ans[index++] = nums[i];
            ans[index++] = nums[i+n];
        }
        return ans;
    }

}