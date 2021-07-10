class Solution {
    public int findMin(int[] nums) {
        
        int first = nums[0];
        int start=0,end=nums.length-1;
        
        //removing duplicates from start and end
        while(start<=end && nums[start] == nums[end]) {
            end--;
        }
        start = 1;
        
        
        while(start<=end) {
            int m = (start+end)/2;
            System.out.println(m);
            if(nums[m]<first && nums[m-1]>nums[m]) return nums[m];
            else if(nums[m]>=first && !(nums[m-1]>nums[m])) start=m+1;
            else end = m-1;
        }
        return nums[0];
    }
}