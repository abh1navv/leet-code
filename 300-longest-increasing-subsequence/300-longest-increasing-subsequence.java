class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        int size = 0, start=0, end=0;
        for(int i=0; i< len; i++) {
            start = 0;
            end = size;
            while(start<end) {
                int m = (start+end)/2;
                if(dp[m] < nums[i]) {
                    start = m+1;
                } else {
                    end = m; 
                }
            }
            
            dp[start] = nums[i];
            if(start == size) size++;
        }
        
        return size;
    }
}