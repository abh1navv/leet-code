class Solution {
    public int findMin(int[] nums) {
        
        
        int start=0, end=nums.length-1;
        
        if(nums[0] <= nums[end]) return nums[0];
        
        while(start<=end) {
            int mid = start+(end -start)/2;
            
            if(mid > 0 && nums[mid]<nums[mid-1]) {
                return nums[mid];
            } else if(nums[end] > nums[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        
        return -1;
    }
}