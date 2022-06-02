class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count=0, product=1, start=0;
        if(k<=1) return 0;
        for(int i=0; i<nums.length;i++) {
            product*=nums[i];
            
            while(product>=k && start<nums.length) {
                product/=nums[start];
                start++;
            }
            count+=(i-start+1);

        }

        return count;
    }
}