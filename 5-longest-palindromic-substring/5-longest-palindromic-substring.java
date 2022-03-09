class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0, start = 0;
        int len = s.length();
        for(int i=0; i<len; i++) {
            int len1 = getLongest(s, i, i, len);
            int len2 = getLongest(s, i, i+1, len);
            
            if(len1 > maxLen) {
                maxLen = len1;
                start = i-len1/2;
            }  
            if(len2 > maxLen) {
                maxLen = len2;
                start = i-len2/2+1;
            } 
        }
        
        return s.substring(start, start+maxLen);
    }
    
    public int getLongest(String s, int start, int end, int len) {
        
        while(start>=0 && end<len && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        
        return end-start-1;
        
    }
}