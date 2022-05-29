class Solution {
    public int maxProduct(String[] words) {
        //List<String> sortedWords = Arrays.stream(words).sorted((a,b) -> b.length() - a.length());
        int n = words.length;
        int max = 0, curr = 0;
        
        boolean[][] flags = new boolean[n][26];
        
        for(int i=0; i<n; i++) {
            for(char c: words[i].toCharArray()) {
                flags[i][c-'a'] = true;
            }
        }
        
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                curr = words[i].length() * words[j].length();
                if(curr > max && noMatch(flags[i], words[j])) {
                    max = curr;
                }
            }
        }
        
        return max;
    }
    
    boolean noMatch(boolean[] flags, String t) {
        for(char c: t.toCharArray()) {
            if(flags[c-'a']) return false;
        }
        
        return true;
    }
}