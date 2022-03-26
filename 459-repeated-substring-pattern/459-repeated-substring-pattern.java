class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int start = 0;
        
        for(int i=len/2; i>=1;i--) {
            if(len%i==0 && matches(s, start, i, i, i+i)) {
                int j=i;
                while(i+j <= len) {
                    if(!matches(s, start, i, j, i+j)) break;
                    else {
                        j+=i;
                    }
                }
                if(j == len) return true;;
            }
        }
        
        return false;
    }
    
    boolean matches(String s, int s1, int e1, int s2, int e2) {
        while(s1<e1 && s2<e2 && s.charAt(s1) == s.charAt(s2)) {
            s1++;
            s2++;
        }
        
        return s1==e1;
    }
}