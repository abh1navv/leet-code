class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max=0;
        for(int i=0; i<k;i++) {
            max+=nums[i];
        }
        double curr = max;
        for(int i=k; i<nums.length;i++) {
            curr = curr+nums[i]-nums[i-k];
            max = Math.max(max, curr);
        }
        
        return max/k;
    }
}