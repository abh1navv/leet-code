class Solution {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        
        int before = 0;
        int after = (int)s.chars().filter(c->c=='0').count();
        int min = before+after;
        
        for(int i=0; i<len; i++) {
            if(s.charAt(i) == '1') before++;
            else if(s.charAt(i) == '0') after--;
            min = Math.min(min, before+after);
        }
        return min;
    }
}