class Solution {
    Map<Integer, Boolean> cache = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        return isBreakable(s, 0, len, wordDict);
    }
    
    public boolean isBreakable(String s, int start, int len, List<String> wordDict) {
        if(cache.containsKey(start)) {
            return cache.get(start);
        }
        boolean ans = false;
        if(start == len) ans = true;
        else {
            for(int i=0; i<wordDict.size(); i++) {
                int end = wordDict.get(i).length();
                if(start+end <= len && s.substring(start, start+end).equals(wordDict.get(i))) {
                    ans = ans || isBreakable(s, start+end, len, wordDict);
                }
            }
        }
        
        cache.put(start, ans);
        
        return ans;
    }
}