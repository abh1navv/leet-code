class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int j=0;
        for(int i=0;i<lenT && j<lenS; i++) {
            if(t.charAt(i) == s.charAt(j)) j++;
        }
        
        return j==lenS;
    }
}