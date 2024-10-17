class Solution {
    
    int[][] cache;
    public int numDistinct(String s, String t) {
        cache = new int[s.length()][t.length()];
        
        for(int i=0; i<s.length(); i++) {
            Arrays.fill(cache[i],-1);
        }
        
        return count(0, 0, s, t);
    }
    
    int count(int index1, int index2, String s, String t) {
        if(index2 == t.length()){
            return 1;
        } else if(index1 == s.length()) {
            return 0;
        } else if(s.length() -index1 < t.length()-index2) {
            return 0;
        }
        
        if(cache[index1][index2] != -1) {
            return cache[index1][index2];
        }
        
        int count = 0;
        
        for(int i=index1; i<s.length(); i++) {
            if(s.charAt(i) == t.charAt(index2)) {
                count += count(i+1, index2+1, s, t);
            }
        }
        
        cache[index1][index2] = count;
        return count;
    }
}