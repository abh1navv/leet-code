class Solution {
    public String longestPalindrome(String s) {
        
        int max=0, start=0;
        
        for(int i=0; i<s.length(); i++) {
            int curr1 = longestPal(s, i, i);
            int curr2 = 0;
            if(i<s.length()-1 && s.charAt(i) == s.charAt(i+1)) {
                curr2 = longestPal(s, i, i+1);
            }
            
            if(curr1 > max) {
                max = curr1;
                start = i-curr1/2;
            }
            
            if(curr2 > max) {
                max = curr2;
                start = i-curr2/2+1;
            }

        }
        
        
        
        return s.substring(start, start+max);
    }
    
    
    int longestPal(String s, int start, int end) {        

        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        
        return end-start-1;
    }
}