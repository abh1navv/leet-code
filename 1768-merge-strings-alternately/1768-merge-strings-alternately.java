class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        String bigger = null;
        int i = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        
        
        
        while(i<Math.min(len1, len2)) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
            i++;
        }
        
        if(len1 > len2) {
            bigger = word1;
        } else {
            bigger = word2;
        }
        
        while(i< Math.max(len1, len2)) {
            sb.append(bigger.charAt(i++));
        }
        
        
        return sb.toString();
    }
}