class Solution {
    public boolean validPalindrome(String s) {
        int len = s.length();
        return isValidPalindrome(s, 0, len-1, true);
    }
    
    boolean isValidPalindrome(String s, int i, int j, boolean entryCase) {
        while(i<j) {
            if(s.charAt(i) != s.charAt(j) && entryCase) {
                return isValidPalindrome(s, i+1, j, false) || isValidPalindrome(s, i, j-1, false);
            } else if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
}



// "cecabbacec"