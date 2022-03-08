class Solution {
    public int numberOfBeams(String[] bank) {

        int prev = 0, count = 0;
        for(int i=0; i<bank.length; i++) {
            int curr = (int)bank[i].chars().filter(c -> c=='1').count();
            if(curr > 0) {
                count += curr*prev;
                prev = curr;
            }
        }
        
        return count;
    }
    
}