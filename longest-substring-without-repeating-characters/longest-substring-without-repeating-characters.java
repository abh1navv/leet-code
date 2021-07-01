class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = Math.min(1,len), current = 0, startPos = -1;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<len; i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                max = current>max?current:max;
                int oldPos = map.get(ch);
                startPos = oldPos > startPos? oldPos: startPos;
                current = i - startPos;
            } else {
                current++;
            }
            map.put(ch, i);
        }
        max = current>max?current:max;
        return max;
    }
}