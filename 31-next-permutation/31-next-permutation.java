class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = -1;
        for(int i=len-1; i>0; i--) {
            if(nums[i] > nums[i-1]) {
                index = i-1;
                break;
            }
        }
        
        reverseAll(nums, Math.max(0,index+1), len-1);
        if(index == -1) {
            return;
        }
        
        for(int i=index;i<len; i++) {
            if(nums[i] > nums[index]) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        
    }
    
    public void reverseAll(int[] nums, int start, int end) {
        int temp;
        while(start<end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}