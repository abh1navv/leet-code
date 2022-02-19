class Solution {
    public int waysToMakeFair(int[] nums) {
        int count = 0;
        int[] left =new int[2];
        int[] right =new int[2];
        
        for(int i=0;i<nums.length;i++) {
            right[i%2] += nums[i];
        }
        
        for(int i=0;i<nums.length;i++) {
            right[i%2]-=nums[i];
            if(right[0] + left[1] == right[1] + left[0]) count++;
            left[i%2]+=nums[i];
        }
        return count;
    }
    
}