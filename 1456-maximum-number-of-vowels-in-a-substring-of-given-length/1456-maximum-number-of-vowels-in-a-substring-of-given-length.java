class Solution {
    public int maxVowels(String s, int k) {
        int max=0;
        for(int i=0; i<k;i++) {
            if(isVowel(s.charAt(i))) max++;
        }
        int curr = max;
        for(int i=k;i<s.length();i++) {
            if(isVowel(s.charAt(i))) curr++;
            if(isVowel(s.charAt(i-k))) curr--;
            
            max = Math.max(curr, max);
        }
        
        return max;
    }
    
    boolean isVowel(char c) {
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}