class Solution {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        
        if(slen > tlen) return false;
        if(slen == 0) return true;
        
        
        for(int i=0; i<tlen-slen+1;i++) {
            if(s.charAt(0) == t.charAt(i)) {
                int k=0;
                for(int j=i; j<tlen; j++) {
                    
                    if(t.charAt(j) == s.charAt(k)) {
                        k++;
                    }
                    if(k == slen) {
                        return true;
                    }
                   
                }
                
            }
        }
        
        return false;
    }
}