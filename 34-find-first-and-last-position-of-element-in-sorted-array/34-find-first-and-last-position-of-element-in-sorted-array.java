class Solution {
    public int[] searchRange(int[] nums, int target) {
        int end = binarySearch(nums, target);
        int start = binarySearch(nums, target-1);
        if(start == end) {
            return new int[] {-1,-1};
        } else {
            return new int[] {start,end-1};
        }
    }
    
    public int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length;
        while(start<end) {
            int m = (start+end)/2;
            if(nums[m] > target) {
                end = m;
            } else {
                start = m+1;
            }
        }
        return end;
    }
}