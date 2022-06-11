class Solution {
    public int minOperations(int[] nums, int x) {

        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, 0);
        
        int sum = 0, left=0, curr=0;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            seen.put(sum, i+1);
            
            if(sum == x) {
                curr = i+1;
                min = Math.min(min, curr);
            }
        }
        
        sum = 0;
        for(int i=nums.length-1; i>=0; i--) {
            sum+= nums[i];

            if(seen.containsKey(x-sum)) {
                left = seen.get(x-sum);
                if(left < i) {
                    curr = left + nums.length-i;
                    min = Math.min(min, curr);
                }
            }
            
            if(sum == x) {
                curr = nums.length-i;
                min = Math.min(min, curr);
            }
            
        }
        
        return min == Integer.MAX_VALUE? -1: min;
    }
}