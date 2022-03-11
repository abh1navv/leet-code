class Solution {
    public int firstUniqChar(String s) {
        int[] pos=new int[26];
        for(int i=0;i<s.length();i++) {
            pos[s.charAt(i)-'a'] = i;
        }
        
        for(int i=0;i<s.length();i++) {
            if(pos[s.charAt(i)-'a'] == i) return i;
            else if(pos[s.charAt(i)-'a'] != 0) pos[s.charAt(i)-'a']=-1;
        }
        
        return -1;
    }
}