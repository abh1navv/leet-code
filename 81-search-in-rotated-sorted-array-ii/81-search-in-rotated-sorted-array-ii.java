class Solution {
    public boolean search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }
    
    public boolean binarySearch(int[] nums, int start, int end, int target) {
        if(start > end) return false;
        if(start == end) {
            if(target == nums[start]) return true;
            else return false;
        }
        int m = (start+end)/2;
        
        if(target == nums[m]) return true;
        else {
            return binarySearch(nums, start, m-1, target) || binarySearch(nums, m+1, end, target);
        }
    }
}