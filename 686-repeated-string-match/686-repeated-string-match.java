class Solution {
    public int repeatedStringMatch(String a, String b) {
        int alen = a.length(), matches=-1;
        int blen = b.length();
        for(int i=0;i <alen; i++) {
            if(a.charAt(i) == b.charAt(0)) {
                matches = getRepetitions(a, b, i, alen, blen);
                if(matches != -1) return matches+1;
            }
        }
        
        return matches;
    }
    
    public int getRepetitions(String a, String b, int start, int n, int blen) {
        for(int i=0; i<blen; i++) {
            if(b.charAt(i)!=a.charAt(start%n)) {
                return -1;
            }
            start++;
        }
        
        return (start-1)/n;
    }
}