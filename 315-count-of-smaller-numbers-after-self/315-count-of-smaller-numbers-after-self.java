class Solution {
    public List<Integer> countSmaller(int[] nums) {

        Integer[] counts=new Integer[nums.length];
        
        Num[] numArr = new Num[nums.length];
        for(int i=0;i<nums.length;i++) {
            counts[i] = 0;
            numArr[i] = new Num(nums[i], i);
        }
        
        mergeSort(numArr, 0, nums.length, counts);
        return Arrays.asList(counts);
    }
    
    void mergeSort(Num[] nums, int start, int end, Integer[] counts) {
        if(start >= end-1) return;
        int mid = (start+end)/2;
        
        mergeSort(nums, start, mid, counts);
        mergeSort(nums, mid, end, counts);
        
        merge(nums, start, mid, end, counts);
    }
    
    void merge(Num[] nums,int start,int mid,int end,Integer[] counts) {
        Num[] sorted = new Num[end-start];
        int i=start, j=mid, k=0, lowerCount = 0;
        while(i<mid && j<end) {
            if(nums[i].val > nums[j].val){
                lowerCount++;
                sorted[k++] = nums[j++];
            } else {
                counts[nums[i].index] += lowerCount;
                sorted[k++] = nums[i++];
            }
        }
        
        while(i<mid) {
            counts[nums[i].index] += lowerCount;
            sorted[k++] = nums[i++];
        }
        
        while(j<end) {
            sorted[k++] = nums[j++];
        }
        
        System.arraycopy(sorted,0,nums,start,end-start);
    }
    
    class Num {
        int val;
        int index;
        
        Num(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    
}