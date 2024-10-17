class Solution {
    int[][] cache;
    public int minDistance(String word1, String word2) {
        cache = new int[ word1.length()][word2.length()];

        return count(0, 0, word1, word2);
    }
    
    
    int count(int index1, int index2, String word1, String word2) {
        
        
        int count = 0;

        
        if(index1 == word1.length()) {
            return word2.length()-index2;
        } else if(index2 == word2.length()) {
            return word1.length()-index1;
        }  
        
        if(cache[index1][index2] !=0) {
            return cache[index1][index2];
        }
        
        if(word1.charAt(index1) == word2.charAt(index2)) {
            count = count(index1+1, index2+1, word1, word2);
        } else {
            count = 1 + Math.min(count(index1, index2+1, word1, word2), Math.min(count(index1+1, index2, word1, word2), count(index1+1, index2+1, word1, word2)));
        }
        
        cache[index1][index2] = count;
        
        return count;
        
    }
}