class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length() || s1.length() == 0) return false;
        
        int len = s1.length();
        
        for(int i=len; i<=s2.length(); i++) {
            if(isAPermutation(s1, s2.substring(i-len, i))) {
                return true;
            }
        }
        
        return false;
    }
    
    
    boolean isAPermutation(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        for(int i=0; i<s1.length(); i++) {
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }
        
        return Arrays.equals(freq1, freq2);
    }
}