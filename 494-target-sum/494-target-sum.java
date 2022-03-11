class Solution {
    Map<String, Integer> cache = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return countWays(nums, 1, target-nums[0]) + countWays(nums, 1, target+nums[0]);
    }
    
    public int countWays(int[] nums, int index, int target) {
        String key = index+" "+target;
        
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        
        int ans = 0;
        if(index == nums.length) {
            ans = target == 0 ? 1: 0;
        } else {
            int min = countWays(nums, index+1, target-nums[index]);
            int more = countWays(nums, index+1, target+nums[index]);
            ans = (min + more);
        }
        
        cache.put(key, ans);
        return ans;
    }
}