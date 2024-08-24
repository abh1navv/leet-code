class Solution {
    public int pivotIndex(int[] nums) {
        int[] right=new int[nums.length];
        right[0] = nums[0];
        int x=0;
        while(x<nums.length-1) {
            right[x+1] = right[x] + nums[x+1];
            x++;
        }
        
        int leftSum = 0;
        int pivot = -1;
        
        for(int i=nums.length-1; i>=0; i--) {
            leftSum += nums[i];
            if(leftSum == right[i]) {
                pivot = i;
            }
        }
        
        return pivot;
    }
}