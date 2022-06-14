class Solution {
    public String truncateSentence(String s, int k) {  
        StringBuilder sb = new StringBuilder();
        
        for(char c: s.toCharArray()) {
            if(c==' ' && k>1) {
                k--;
            } else if(c==' ') {
                break;
            } 
            sb.append(c);
        }
        return sb.toString();
    }
}