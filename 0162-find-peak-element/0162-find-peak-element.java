class Solution {
    public int findPeakElement(int[] nums) {
        
        int start=0, end=nums.length-1;
        
        if(nums.length == 1) return 0;
        if(nums.length == 2) return nums[0] > nums[1] ? 0:1;
        
        return findPeak(nums, start, end);
    }
    
    int findPeak(int[] nums, int start, int end) {
        if(start > end) return -1;
        else if(start==end) {
            if ((start==0 ||nums[start] > nums[start-1]) && (start==nums.length-1 || nums[start] > nums[start+1]) ) {
                return start;         
            } else {
                return -1;
            }
        }
        
        int mid = start + (end-start)/2;

        if((mid==0 ||nums[mid] > nums[mid-1]) && (mid==nums.length-1 || nums[mid] > nums[mid+1]) ) {
            return mid;
        } else {
            int left = findPeak(nums, start, mid-1);
            if(left != -1) return left; 

            int right = findPeak(nums, mid+1, end);
            if(right != -1) return right; 
        }
        
        
        return -1;
    }
}