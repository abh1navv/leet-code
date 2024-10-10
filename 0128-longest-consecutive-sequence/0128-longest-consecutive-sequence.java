class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> seen = new HashSet<>();
        
        int max = 0;
    
        
        for(int n: nums) {
            seen.add(n);
        }
        
        for(int n:nums) {
            
            if(!seen.contains(n-1)) {
                int x = n;
                int curr = 1;
                while(seen.contains(++x)) {
                    curr++;
                }
                max = Math.max(max, curr);
            } 

            
            
        }
        
        
        
        return max;
    }
}