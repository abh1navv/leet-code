class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int index = 0;
        k=k%n;
        
        int i=n-k;//;i<nums.length; i++) {
        List<Integer> rest = new ArrayList<>();
        for(int m=i; m<n; m++) {
            rest.add(nums[m]);
        }
        for(int m=i-1; m>=0; m--) {
            nums[(k+m) % n] = nums[m];
        }
        //System.out.println(Arrays.toString(nums));
        for(int j=0; j<rest.size();j++) {
            nums[j] = rest.get(j);
        }
    }
}