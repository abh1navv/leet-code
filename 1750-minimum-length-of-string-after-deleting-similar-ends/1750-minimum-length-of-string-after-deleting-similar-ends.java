class Solution {
    public int minimumLength(String s) {
        int len = s.length();
        int i=0, j=len-1;  
        while(i<j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                while(i<=j && s.charAt(i) == s.charAt(i-1)) i++;
                while(j>=i && s.charAt(j) == s.charAt(j+1)) j--;
            } else {
                break;
            }
        }
        
        return j-i+1;
    }
}