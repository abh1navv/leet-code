class Solution {
    public int repeatedStringMatch(String a, String b) {
        int alen = a.length(), matches=-1;
        for(int i=0;i <alen; i++) {
            if(a.charAt(i) == b.charAt(0)) {
                matches = getRepetitions(a, b, i, alen);
                if(matches != -1) return matches+1;
            }
        }
        
        return matches;
    }
    
    public int getRepetitions(String a, String b, int start, int n) {
        for(int i=0; i<b.length(); i++) {
            if(b.charAt(i)!=a.charAt(start%n)) {
                return -1;
            }
            start++;
        }
        
        return (start-1)/n;
    }
}