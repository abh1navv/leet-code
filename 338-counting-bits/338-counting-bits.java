class Solution {
    public int[] countBits(int n) {
        int bits = 0, prevCount = 0;
        int ans[]=new int[n+1];
        ans[0] = 0;
        
        for(int i=1; i<=n;i++) {
            int count = 0;
            int j=i;
            while(j>0) {
                if(ans[j] != 0) {
                    count+=ans[j];
                    break;
                } else if(j%2 == 0) {
                    j/=2;
                } else {
                    count+=1;
                    j/=2;
                }
            }
            ans[i] = count; 
        }
        
        return ans;
    }
    
}