class Solution {
    public boolean rotateString(String s, String goal) {
        int goalLen = goal.length();
        int sLen = s.length();
        char firstChar = goal.charAt(0);
        if(sLen != goalLen) return false;
        
        for(int i=0; i< sLen;i++) {
            if(s.charAt(i) == firstChar && isSubstring(s, goal, i, goalLen, sLen)) return true;
        }
            
        return false;
    }
    
    boolean isSubstring(String s, String goal, int offset, int goalLen, int sLen) {
        for(int i=0; i< goalLen; i++) {
            if(s.charAt((i+offset)%sLen) != goal.charAt(i)) return false;
        }
        return true;
    }
}