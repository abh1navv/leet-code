class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        List<Integer> majority = new ArrayList<>();
        Arrays.sort(nums);
        int nByThree = len/3;
        int count = 1;
        int current = nums[0];
       for(int i=1;i<len;i++) {
            if(nums[i] == current) {
                count++;
            } else {
                if(count>nByThree) majority.add(nums[i-1]);
                count = 1;
                current = nums[i];
            }
       }
       if(count>nByThree) majority.add(nums[len-1]);

        return majority;
    }
}