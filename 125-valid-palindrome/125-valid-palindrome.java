class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        int len = s.length();
        int mid2 = len/2, mid1;
        if(len%2 == 1) {
            mid1 = len/2;
        } else {
            mid1 = len/2 - 1;
        }
        
        while(mid1 > -1 && mid2 < len) {
            if(s.charAt(mid1--) != s.charAt(mid2++)) return false;
            
        }
        
        
        return true;
    }
}