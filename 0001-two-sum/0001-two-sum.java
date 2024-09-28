class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            int curr = target-nums[i];
            if(numToIndex.containsKey(curr)) {
                return new int[]{i, numToIndex.get(curr)};
            }
            numToIndex.put(nums[i], i);
        }
        
        return null;
    }
}