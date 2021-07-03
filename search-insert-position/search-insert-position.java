class Solution {
    public int searchInsert(int[] nums, int target) {
        int s=0,e=nums.length-1, m=0;
        while(s<=e) {
            m = (s+ e)/2;
            if(s==e) return nums[s]<target?s+1:s;
            if(nums[m] > target) e=m-1;
            else if (nums[m] < target) s = m+1;
            else return m;
        }
        return m;
    }
    
}