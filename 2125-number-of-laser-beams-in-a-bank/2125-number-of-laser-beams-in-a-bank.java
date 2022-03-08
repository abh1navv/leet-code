class Solution {
    public int numberOfBeams(String[] bank) {

        int prev = 0, count = 0;
        for(int i=0; i<bank.length; i++) {
            int curr=0;
             for(char c: bank[i].toCharArray()) {
                 if(c=='1'){
                     curr++;
                }  
             }
            if(curr > 0) {
                count += curr*prev;
                prev = curr;
            }
        }
        
        return count;
    }
    
}