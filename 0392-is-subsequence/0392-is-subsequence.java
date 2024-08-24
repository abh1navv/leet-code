class Solution {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        
        if(slen > tlen) return false;
        if(slen == 0) return true;
        
        int k=0;
        
        for(int i=0; i<tlen && k<slen ;i++) {
            if(t.charAt(i) == s.charAt(k)) {
                k++;
            }
        }
        
        return k == slen;
    }
}