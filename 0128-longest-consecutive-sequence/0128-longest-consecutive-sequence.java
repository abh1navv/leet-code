class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> seen = new HashSet<>();
        
        int max = 0;
    
        
        for(int n: nums) {
            seen.add(n);
        }
        
        for(int n:nums) {
            int x = n-1;
            int curr = 1;
            if(!seen.contains(x)) {
                while(seen.contains(x+2)) {
                    curr++;
                    x++;
                }
            } 

            
            max = Math.max(max, curr);
        }
        
        
        
        return max;
    }
}