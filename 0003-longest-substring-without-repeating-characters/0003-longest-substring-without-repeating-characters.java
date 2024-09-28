class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToIndex = new HashMap<>();
        
        int start = 0;
        int maxCount = 0;
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(charToIndex.containsKey(ch) && charToIndex.get(ch) >= start) {
                maxCount = Math.max(i-start, maxCount);
                start = charToIndex.get(ch)+1;
            } 
                
            charToIndex.put(ch, i);
        }
        maxCount = Math.max(s.length()-start, maxCount);

        
        return maxCount;
    }
}