class Solution {
    public int jump(int[] nums) {
        int len = nums.length-1;
        int jumps = 0;
        for(int i=0;i<len;) {
            int curr = nums[i];
            if(curr+i>=len) {
                jumps++;
                break;
            }
            int max = nums[i+1] + i+1;
            int maxIn = i+1;
            for(int j=2;j<=curr;j++) {
                int index = i+j;
                int dist = nums[index] + index;
                if(index>len || dist >= len) {
                    maxIn = index;
                    break;
                } else if (dist >= max) {
                    max = dist;
                    maxIn = index;
                }
            }
            jumps++;
            i = maxIn;
        }
        
        return jumps;
    }
}