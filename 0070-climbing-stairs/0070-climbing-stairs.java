class Solution {
    
    Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if(cache.containsKey(n)) return cache.get(n);
        if(n <= 1) return 1;
        int total = climbStairs(n-1) + climbStairs(n-2);
        
        cache.put(n, total);
        return total;
    }
}