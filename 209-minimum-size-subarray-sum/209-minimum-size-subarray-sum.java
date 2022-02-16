class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int len = nums.length;
        int index = len+1, subLen = 0, minLen = 0;
        int sum = 0;
        for(int i=0;i<len;i++) {
            sum+=nums[i];
            if(sum>=target) {
                index = i;
                break;
            }
        }
        
        if(index == len+1) return 0;
        else {
            minLen = index+1;
            subLen = minLen;
        }
        
        
        for(int i=minLen;i<len;) {
            if(sum > target) {
                if(subLen < minLen) minLen = subLen;
                sum-= nums[i-subLen];
                subLen--;
            }
            else if (sum == target) {
                if(subLen < minLen) minLen = subLen;
                sum = sum + nums[i] - nums[i-subLen];
                i++;
            } else {
                sum+=nums[i];
                subLen++;
                i++;
            }
        }
        while(sum > target) {
            sum-= nums[len-subLen];
            if(sum>=target) {
              subLen--;    
            }
            
        }
        return Math.min(subLen, minLen);
        
    }
}