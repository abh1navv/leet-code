class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();

        
        if(len > s2.length() || len == 0) return false;
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        for(int i=0; i<len; i++) {
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }
        
        
        for(int i=len; i<s2.length(); i++) {
            if(Arrays.equals(freq1, freq2)) {
                return true;
            }
            
            freq2[s2.charAt(i)-'a']++;
            freq2[s2.charAt(i-len)-'a']--;
        }
        
        return Arrays.equals(freq1, freq2);
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