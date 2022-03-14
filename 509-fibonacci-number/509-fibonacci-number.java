class Solution {
    public int fib(int n) {
        int first = 0;
        int second = 1;
        if(n<2) return n;
        
        for(int i=2; i<=n; i++) {
            second = first+second;
            first = second - first;
        }
        
        return second;
    }
}