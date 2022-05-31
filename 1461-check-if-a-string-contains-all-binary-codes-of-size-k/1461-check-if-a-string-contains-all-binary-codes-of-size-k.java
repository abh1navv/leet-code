class Solution {
    public boolean hasAllCodes(String s, int k) {
        int required = (int)Math.pow(2, k);        
        int n=0, bit = 0;
        int len = s.length();
        
        Set<Integer> uniques = new HashSet<>();
        
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
                uniques.add(bit);
            }
        }
        
        
        return uniques.size() == required;
    }
}