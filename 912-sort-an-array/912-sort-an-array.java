class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length);
        
        return nums;
    }
    
    public void mergeSort(int[] nums, int start, int end){
        if(start>=end-1) return;
        int mid = (start+end)/2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid, end);
        
        merge(nums, start, mid, end);
    }
    
    public void merge(int[] nums, int start, int mid, int end){
        int[] right = new int[end-mid];
        int[] left = new int[mid-start];
        System.arraycopy(nums, mid, right, 0,end-mid);
        System.arraycopy(nums, start, left, 0,mid-start);
        
        int i=0, j=0, k=start;
        while(j!=right.length && i!=left.length) {
            if(right[j] < left[i]) {
                nums[k++] = right[j++];
            } else {
                nums[k++] = left[i++];
            }
        }
        
        while(j!=right.length) {
            nums[k++] = right[j++];
        }
        
        while(i!=left.length) {
            nums[k++] = left[i++];
        }
        
    }
}