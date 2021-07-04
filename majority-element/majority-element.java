class Solution {
    public int majorityElement(int[] nums) {
        
        int len = nums.length;
        int major = 0, count=0;
        for(int i=0;i<len;i++) {
            if(count==0) {
                count++;
                major = nums[i];
            } else if(major == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}