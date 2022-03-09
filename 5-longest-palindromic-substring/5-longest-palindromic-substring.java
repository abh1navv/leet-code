class Solution {
    public String longestPalindrome(String s) {
        String maxSub = "";
        int len = s.length();
        for(int i=0; i<len; i++) {
            String longestOdd = getLongest(s, i, i, len);
            String longestEven = "";
            if(i<len-1 && s.charAt(i) == s.charAt(i+1)) {
               longestEven = getLongest(s, i, i+1, len);
            }
            if(longestOdd.length() > maxSub.length()) {
                maxSub = longestOdd;
            }  
            if(longestEven.length() > maxSub.length()) {
                maxSub = longestEven;
            }

        }
        
        return maxSub;
    }
    
    public String getLongest(String s, int start, int end, int len) {
        
        while(start>=0 && end<len && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        
        return s.substring(start+1, end);
        
    }
}