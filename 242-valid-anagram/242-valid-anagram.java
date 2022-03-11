import java.util.Collection;
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        if(s.length() != t.length()) return false;
        
        for(char c: s.toCharArray()) {
            arr[c-'a']++;
        }
        
        for(char c: t.toCharArray()) {
            arr[c-'a']--;
        }
        for(int v: arr) {
            if(v != 0) return false;
        }
        
        return true;
    }
    
}