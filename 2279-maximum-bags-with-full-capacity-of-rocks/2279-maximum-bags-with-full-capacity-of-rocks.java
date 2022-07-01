class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        for(int i=0; i<capacity.length; i++) {
            capacity[i]-=rocks[i];
        }        
        Arrays.sort(capacity);
        int ans = 0;
        for(int i=0; i<capacity.length;i++) {
            if(capacity[i] <= additionalRocks) {
                ans++;
                additionalRocks-=capacity[i];
            }
        }
        
        return ans;
    }
    
    
}