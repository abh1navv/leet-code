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
        
        if(Arrays.equals(freq1, freq2)) {
            return true;
        }
        
        
        for(int i=len; i<s2.length(); i++) {
            freq2[s2.charAt(i)-'a']++;
            freq2[s2.charAt(i-len)-'a']--;
            
            if(Arrays.equals(freq1, freq2)) {
                return true;
            }
            
        }
        
        return false;
    }
    
}