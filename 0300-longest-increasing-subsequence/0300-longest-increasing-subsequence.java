class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[]=new int[nums.length+1];
        
        int size=0;
        
        for(int i=0; i<nums.length; i++) {
            int start=0, end=size;
            while(start<end) {
                int mid = start + (end-start)/2;
                if(dp[mid] < nums[i]) { // find position of last element higher than nums
                    start = mid+1;
                } else {
                    end = mid;
                }
            }
            dp[start] = nums[i]; // replace last element higher than nums with nums - it forms a subsequence of same length but with lesser end
            if(start == size) size++;
        }
        
        return size;
    }
}