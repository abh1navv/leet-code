class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int start = 0;
        
        for(int i=1; i<=len/2;i++) {
            if(s.substring(start,i).equals(s.substring(i,i+i))) {
                int j=i;
                String first = s.substring(start,i);
                while(i+j <= len) {
                    String second = s.substring(j,i+j);
                    //System.out.println(first+":"+second);
                    if(!first.equals(second)) break;
                    else {
                        j+=i;
                    }
                }
                if(j == len) return true;;
            }
        }
        
        return false;
    }
}