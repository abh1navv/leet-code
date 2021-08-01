class Solution {
    public int numPrimeArrangements(int n) {
        int count = n>=2?1:0;
        int negCount = 1, j=0;
        long perms = 1;
        for(int i=3;i<=n;i++) {
            for(j=2;j<i/2+1;j++) {
                if(i%j==0) break;
            }
            if(j==i/2+1) {
                perms=(perms*++count)%(1000000007);
            } else {
                perms=(perms*++negCount)%(1000000007);
            }
        }
        return (int)perms;
        
    }
}