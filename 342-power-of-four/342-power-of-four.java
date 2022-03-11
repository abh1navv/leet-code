class Solution {
    public boolean isPowerOfFour(int n) {
        int m = (int)Math.sqrt(n);
        if(n<=0 || m*m != n) return false;
        
        return Math.pow(2,31) % m == 0;
    }
}