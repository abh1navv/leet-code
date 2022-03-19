class Solution {
    public long maximumSubsequenceCount(String s, String pattern) {
        long num0 = 0;
        long num1 = 0;
        long patterns = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == pattern.charAt(1)) {
                num1++;
                patterns+=num0;
                if(pattern.charAt(1) == pattern.charAt(0)) num0=num1;
            } else if(s.charAt(i) == pattern.charAt(0))  {
                num0++;
            }

        }
        
        return num0>num1?patterns+num0:patterns+num1;
    }
}