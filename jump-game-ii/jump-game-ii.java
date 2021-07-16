class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int jumps = 0;
        for(int i=0;i<len-1;) {
            int rem = len-i-1;

            if(nums[i]>=rem) {
                jumps++;
                break;
            }
            int max = nums[i+1] + i+1;
            int maxIn = i+1;
            for(int j=1;j<=nums[i];j++) {

                int index = i+j;
              //System.out.println("Num:"+nums[index]+" : "+(len-index-1));

                if(index>=len || nums[index] >= len-index-1) {
                    maxIn = index;
                    break;
                } else if (nums[index] + index >= max) {
                    max = nums[index] + index;
                    maxIn = index;
                }
            }
            jumps++;
            i = maxIn;
            //System.out.println(i);
        }
        
        return jumps;
    }
}