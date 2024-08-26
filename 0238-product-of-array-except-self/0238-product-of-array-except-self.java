class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix[]=new int[nums.length];
        int product = 1;
        for(int i=0; i< nums.length; i++) {
            product = product * nums[i];
            prefix[i] = product;
        }
        
        product = 1;
        for(int i=nums.length-1; i>0; i--) {
            prefix[i] = prefix[i-1] * product;
            product = product * nums[i];
        }
        prefix[0] = product;
        
        return prefix;
        
    }
}