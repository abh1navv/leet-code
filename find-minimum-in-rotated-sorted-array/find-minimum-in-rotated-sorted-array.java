class Solution {
    public int findMin(int[] nums) {
        int first = nums[0];
        int start=1,end=nums.length-1;
        while(start<=end) {
            int m = (start+end)/2;
            if(nums[m]<first && nums[m-1]>nums[m]) return nums[m];
            else if(nums[m]>first) start=m+1;
            else end = m-1;
        }
        return nums[0];
    }
}