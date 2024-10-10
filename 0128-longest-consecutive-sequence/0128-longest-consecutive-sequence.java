class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> seen = new HashSet<>();
        
        int max = 0;
    
        
        for(int n: nums) {
            seen.add(n);
        }
        
        for(int n:nums) {
            int curr = 1;
            if(!seen.contains(n-1)) {
                seen.remove(n);
                int x = n+1;
                while(seen.contains(x)) {
                    seen.remove(x);
                    x++;
                    curr++;
                }
                
            } 
            max = Math.max(max, curr);

            
            
        }
        
        
        
        return max;
    }
}