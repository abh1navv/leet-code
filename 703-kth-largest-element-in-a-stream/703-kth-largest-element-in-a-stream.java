class KthLargest {

    int k;
    List<Integer> nums;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(this.nums, (a,b)->b-a);
    }
    
    public int add(int val) {
        if(nums.size()<=k) {
            nums.add(val);
        }
        if(nums.size()>=k && nums.get(k-1) > val) return nums.get(k-1);
        int i=k-1,flag=0;
        while(i>0) {
            if(nums.get(i-1) > val) {
                nums.set(i, val);
                flag=1;
                break;
            } else {
                nums.set(i,nums.get(i-1));
                i--;
            }
        }
        if(flag == 0) {
            nums.set(0,val);
        }
        
        return nums.get(k-1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */