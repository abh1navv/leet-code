class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }
    
    public int binarySearch(int[] nums, int start, int end, int target) {
        if(start > end) return -1;
        if(start == end) {
            if(target == nums[start]) return start;
            else return -1;
        }
        int m = (start+end)/2;
        
        if(target == nums[m]) return m;
        else {
            return Math.max(binarySearch(nums, start, m-1, target), binarySearch(nums, m+1, end, target));
        }
    }
}