class Solution {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        
        int before = 0;
        int after = getInversions(s);
        int min = before+after;
        
        for(int i=0; i<len; i++) {
            char ch = s.charAt(i);
            if(ch == '1') before++;
            else if(ch == '0') after--;
            //System.out.println(before+" "+ i+" "+after);
            min = Math.min(min, before+after);
        }
        
        return min;
    }
    
    public int getInversions(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') count++;
        }
        return count;
    }
}