class Solution {
    public boolean hasAllCodes(String s, int k) {
        int required = (int)Math.pow(2, k);        
        int n=0, bit = 0;
        int len = s.length();
        
        boolean[] seen = new boolean[required];
        
        char ch;
        while(n<len) {
            ch = s.charAt(n);
            //shift left
            bit = bit << 1;
            
            // set new bit
            bit = bit | (ch-'0');
            
            //delete old bit
            bit = bit & ~ (1 << k);
            
            n++;
            
            if(n>=k) {
                seen[bit] = true;
            }
        }
        
        for(boolean b: seen) if(!b) return false;
        return true;
    }
}