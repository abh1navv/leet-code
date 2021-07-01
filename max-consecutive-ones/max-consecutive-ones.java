class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int maxones =0;
        int ones=0;

        for(int i=0; i<len; i++) {
            if (nums[i] == 1)  {
                ones++;
                if (ones > maxones ) maxones = ones; 
            } else {
                ones = 0;
            }
        }
        return maxones;
    }
}