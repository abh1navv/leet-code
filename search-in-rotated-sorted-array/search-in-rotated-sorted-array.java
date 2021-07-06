class Solution {
    public int search(int[] nums, int target) {
        int start=0,end=nums.length-1;
        int pivot = findPivot(nums);
        int left = binarySearch(nums,0,pivot-1, target);
        return left>-1?left:binarySearch(nums,pivot,end, target);
        
    }
    
    public int binarySearch(int[] nums,int start,int end, int target) {
        while(start<=end) {
            int m = (start+end)/2;
            if(target == nums[m]) return m;
            else if(target < nums[m]) end=m-1;
            else start = m+1;
        }
        return -1;
    }
    
    public int findPivot(int[] nums) {
        int first = nums[0];
        int start=1,end=nums.length-1;
        while(start<=end) {
            int m = (start+end)/2;
            if(nums[m]<first && nums[m-1]>nums[m]) return m;
            else if(nums[m]>first) start=m+1;
            else end = m-1;
        }
        return 0;
    }
}