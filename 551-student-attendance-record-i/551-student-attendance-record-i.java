class Solution {
    public boolean checkRecord(String s) {
        int lateCount = 0, absentCount = 0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            
            if(ch == 'L') {
                lateCount++;
            } else {
                if(lateCount>=3 || (ch == 'A' && ++absentCount >= 2)) {
                    return false;
                }
                lateCount = 0;
            }
            
            if(lateCount>=3) return false;
        }
        
        return true;
    }
}