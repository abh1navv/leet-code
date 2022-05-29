class Solution {
    public int maxProduct(String[] words) {
        Arrays.sort(words, (a,b) -> b.length() - a.length());
        int n = words.length;
        int max = 0, curr = 0;
        
        int[] flags = new int[n];
        
        for(int i=0; i<n; i++) {
            for(char c: words[i].toCharArray()) {
                flags[i] = flags[i] | ( 1 << (c-'a'));
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
    
    boolean noMatch(int flags, String t) {
        for(char c: t.toCharArray()) {
            if((flags & (1 << (c-'a'))) != 0) return false;
        }
        
        return true;
    }
}