class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        int j=0,k=0,curr;
        for(int i=0; i<nums.length-2; i++) {
            j=i+1;
            k=nums.length-1;
            while(j<k) {
                curr = nums[i]+nums[j]+nums[k];
                if(curr < target) {
                    j++;
                } else {
                    k--;
                }
                if(Math.abs(target-curr) < minDiff) {
                    minDiff = Math.abs(target-curr);
                    minSum = curr;
                }
            }
        }
        
        return minSum;
    }
}