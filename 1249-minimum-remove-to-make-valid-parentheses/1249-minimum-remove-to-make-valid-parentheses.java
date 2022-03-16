class Solution {
    public String minRemoveToMakeValid(String s) {
        int countStart = 0, countEnd = 0;
        
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        
        for(int i=0; i<len; i++) {
            if(sb.charAt(i) == '(') {
                countStart++;
            } else if(sb.charAt(i) == ')') {
                countEnd++;
                if(countEnd > countStart) {
                    sb.deleteCharAt(i);
                    len--;
                    i--;
                    countEnd--;
                }
            }
        }
        
        if(countStart != countEnd) {
            countStart = 0;
            countEnd = 0;
            
            for(int i=len-1; i>=0; i--) {
                if(sb.charAt(i) == '(') {
                    countStart++;
                    if(countEnd < countStart) {
                        sb.deleteCharAt(i);
                        countStart--;
                    }
                } else if(sb.charAt(i) == ')') {
                    countEnd++;
                }
            }
        }
        
        return sb.toString();
        
    }
}