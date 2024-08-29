class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        quickSelect(0, nums.length-1, nums, k);
        return nums[nums.length-k];
    }
    
    void quickSelect(int start, int end, int[] nums, int k) {
        if(start >= end) return;

        int i=start+1, j=end;
        while(i<=j) {
            while(i<=j && nums[i] <= nums[start]) i++;
            while(j>=i && nums[j] >= nums[start]) j--;
            
            if(i<j) {
                swap(i, j, nums);
            } else {
                swap(start, j, nums);
                //System.out.println(Arrays.toString(nums));
                
                if(j>nums.length-k) {
                   while(j>start && nums[j] == nums[j-1]) j--;
                    end = j-1;
                } else if(j < nums.length-k) {
                    while(j<end && nums[j] == nums[j+1]) j++;
                    start = j+1;
                } else {
                    return;
                }
                i=start+1;j=end;
            }
        }
    }
    
    void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}