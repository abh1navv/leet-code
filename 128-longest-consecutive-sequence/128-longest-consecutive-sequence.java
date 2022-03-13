class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for(int n:nums) {
            map.put(n,1);
        }

        for(int n:nums) {
            int x = n-1;
            while(map.containsKey(x)) { 
                map.put(n, map.get(n)+map.get(x));
                map.remove(x);
                x--;
            }
            max = Math.max(max, map.getOrDefault(n,0));
        }        
        
        
        return max;
    }
}