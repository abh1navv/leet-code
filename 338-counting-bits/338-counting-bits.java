class Solution {
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        ans[0] = 0;
        int count = 0, j=0;
        for(int i=1; i<=n;i++) {
            count = 0;
            j=i;
            while(j>0) {
                if(ans[j] != 0) {
                    count+=ans[j];
                    break;
                } 
                count+=j%2;
                j/=2;
            }
            ans[i] = count; 
        }
        
        return ans;
    }
    
}