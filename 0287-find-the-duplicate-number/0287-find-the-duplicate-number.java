class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] freq=new boolean[100001];
        
        for(int n:nums) {
            if(freq[n]) return n;
            else freq[n] = true;
        }
        
        return -1;
    }
}