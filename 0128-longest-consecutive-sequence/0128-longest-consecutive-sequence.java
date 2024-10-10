class Solution {
    public int longestConsecutive(int[] nums) {
        
        Map<Integer, Integer> seen = new HashMap<>();
        
        int max = 0;
    
        
        for(int n: nums) {
            seen.put(n, 1);
        }
        
        for(int n:nums) {
            int x = n-1;
            int curr = 1;
            if(!seen.containsKey(x)) {
                while(seen.containsKey(x+2)) {
                    curr++;
                    x++;
                }
            } 

            
            max = Math.max(max, curr);
        }
        
        
        
        return max;
    }
}