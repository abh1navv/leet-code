class Solution {
    public String reverseVowels(String s) {
        
        int first = 0; 
        int last = s.length()-1;
        int j,k;
        
        StringBuilder sb = new StringBuilder(s);
        
        while(first<last) {
            j=first;
            k=last;
            while(j<k && !isVowel(sb.charAt(j))) j++;
            while(k>j && !isVowel(sb.charAt(k))) k--;
            
            swap(sb, j, k);
            
            first = j+1;
            last = k-1;
        }
        
        return sb.toString();
    }
    
    
    boolean isVowel(char c) {
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
    
    void swap(StringBuilder s, int j, int k) {
        var temp = s.charAt(j);
        s.setCharAt(j, s.charAt(k));
        s.setCharAt(k, temp);
    }
    
}