public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0, count=0;
        while(n!=0) {
            count++;
            ans = ans << 1;
            ans = ans | (n&1);
            n = n>>>1;
        }
        
        ans = ans << (32-count);
        
        return ans;
    }
}