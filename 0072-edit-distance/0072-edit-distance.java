class Solution {
    
    Map<String, Integer> cache = new HashMap<>();
    public int minDistance(String word1, String word2) {
        return count(0, 0, word1, word2);
    }
    
    
    int count(int index1, int index2, String word1, String word2) {
        String key = index1+":"+index2;
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        
        int count = 0;

        
        if(index1 == word1.length()) {
            count = word2.length()-index2;
        } else if(index2 == word2.length()) {
            count = word1.length()-index1;
        } else if(word1.charAt(index1) == word2.charAt(index2)) {
            count = count(index1+1, index2+1, word1, word2);
        } else {
            count = 1 + Math.min(count(index1, index2+1, word1, word2), Math.min(count(index1+1, index2, word1, word2), count(index1+1, index2+1, word1, word2)));
        }
        
        cache.put(key, count);
        
        return count;
        
    }
}