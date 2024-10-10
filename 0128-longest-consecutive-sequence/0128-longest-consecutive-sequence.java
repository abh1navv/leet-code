class Solution {
    public int longestConsecutive(int[] nums) {
        
        Map<Integer, Integer> seen = new HashMap<>();
        
        int max = 0;
    
        
        for(int n: nums) {
            seen.put(n, 1);
        }
        
        for(int n:nums) {
            int x = n-1, curr=0;
            while(seen.containsKey(x)) {
                curr = seen.get(x) + seen.get(n);
                seen.put(n, curr);
                seen.remove(x--);
            } 

            
            max = Math.max(max, seen.getOrDefault(n,0));
        }
        
        
        
        return max;
    }
}