class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSelect(0, nums.length-1, nums, nums.length-k);
        return nums[nums.length-k];
    }
    
    public void quickSelect(int start, int end, int[] nums, int k) {        
        while(true) {
            int pivot = nums[start];
            int j=start+1;
            for(int i=start+1; i<=end; i++) {
                if(nums[i] < pivot) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j++;
                } 
            }

            int temp = nums[j-1];
            nums[j-1] = pivot;
            nums[start] = temp;

            if(j-1 > k) 
                end = j-2;
            else if(j-1 < k)
                start=j;
            else 
                return;
        }
    }
}