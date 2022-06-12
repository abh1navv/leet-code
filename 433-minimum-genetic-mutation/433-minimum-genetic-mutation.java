class Solution {
    public int minMutation(String start, String end, String[] bank) {
        return ladderLength(start, end, Arrays.asList(bank));
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;
        Set<String> seen = new HashSet<>();
        seen.add(beginWord);
        
        int ans = countSequence(seen, endWord, wordList, 0, beginWord);
        return ans == Integer.MAX_VALUE?-1:ans;
    }
    
    public int countSequence(Set<String> seen, String endWord, List<String> wordList, int count, String current) {
        if(current.equals(endWord)) return count;
        
        int min = Integer.MAX_VALUE;
        for(String word: wordList) {
            if(differsByOne(word, current) && seen.add(word)) {
                min = Math.min(min, countSequence(seen, endWord, wordList, count+1, word));
                seen.remove(word);
            }
        }
        
        return min;
    }
    
    boolean differsByOne(String s1, String s2) {        
        int count = 0;
    
        for(int i=0; i<8; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count++;
                if(count > 1) return false;
            }    
        }
        
        return count==1;
    }
}