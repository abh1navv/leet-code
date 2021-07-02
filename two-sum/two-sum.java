class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] positions = new int[2];
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<len; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                positions[0] = map.get(complement);
                positions[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return positions;
    }
}