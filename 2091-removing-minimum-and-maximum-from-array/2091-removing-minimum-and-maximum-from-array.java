class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, maxPos=-1, minPos=-1;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxPos = i;
            }
            
            if(nums[i] < min) {
                min = nums[i];
                minPos = i;
            }
        }
        int a = Math.min(minPos, maxPos);
        int b = Math.max(minPos, maxPos);
  
        return Math.min(a+1+n-b, Math.min(b+1, n-a));
    }
}