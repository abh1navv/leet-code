class Solution {
    
    public int climbStairs(int n) {
        if(n==1) return n;

        int prev = 1, prevPrev = 1;
        
        for(int i=2; i<n; i++) {
            int temp = prevPrev+prev;
            prevPrev = prev;
            prev = temp;
        }
        
        return prev+prevPrev;
    }
}