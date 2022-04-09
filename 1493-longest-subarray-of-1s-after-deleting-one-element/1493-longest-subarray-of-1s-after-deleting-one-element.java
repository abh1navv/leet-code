class Solution {
    public int longestSubarray(int[] nums) {
        int max=0,start=0,lastZero=0;
        boolean flag = true;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==1 || flag) {
                if(nums[i]==0) {
                    flag=false;
                    lastZero=i;
                }
            } else {
                max = Math.max(max, i-start-1);
                //System.out.println(max+":"+i);
                start=lastZero+1;
                flag=true;
                i--;
            }
        }
        max = Math.max(max, nums.length-1-start);

        return max;
    }
}