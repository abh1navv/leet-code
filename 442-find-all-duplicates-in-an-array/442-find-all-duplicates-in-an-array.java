class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length; i++) {
            while(nums[i]!=i+1 && nums[nums[i]-1]!=nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
        }
        
        for(int i=0;i<nums.length; i++) {
            if(nums[i]!=i+1) res.add(nums[i]);
        }

        
        return res;
    }
}