class Solution {
    public int findPeakElement(int[] nums) {
        int first = nums[0];
        int start=0,end=nums.length;
        int len=end-1;
        
        if(nums.length==1 || nums[0] > nums[1]) return 0;
        else if(nums[end-1] > nums[end-2]) return end-1;
        
        while(start<=end) {
            int m = start + (end-start)/2;
            if(m>0 && m<len && nums[m]>nums[m-1] && nums[m+1]<nums[m]) return m;
            else if(m<len&&nums[m]<nums[m+1]) start=m+1;
            else if(m>0&&nums[m-1]>nums[m]) end = m-1;
        }
        
        return -1;
    }
    
}