class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for(int n:nums) {
            map.put(n,1);
        }
        int x=0;
        for(int n:nums) {
            x = n-1;
            int curr = map.getOrDefault(n,0);
            while(map.containsKey(x)) { 
                curr+=map.get(x);
                map.remove(x);
                x--;
            }
            map.put(n, curr);
            max = Math.max(max, curr);
        }        
        
        
        return max;
    }
}