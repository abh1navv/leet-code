class Solution {
    public boolean divideArray(int[] nums) {
        int[] count = new int[501];
        
        for(int n:nums) {
            if(count[n] == 1) count[n]--;
            else if(count[n] == 0) count[n]++;
        }
                
        for(int c:count) {
            if(c != 0) return false;
        }
        
        return true;
    }
}