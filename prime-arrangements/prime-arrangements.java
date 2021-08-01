class Solution {
    public int numPrimeArrangements(int n) {
        int count = n>=2?1:0;
        int negCount = 1;
        long perms = 1;
        for(int i=3;i<=n;i++) {
            if(isPrime(i)) {
                count++;
                perms=(perms*count)%(1000000007);
            } else {
                negCount++;
                perms=(perms*negCount)%(1000000007);
            }
        }
        
        return (int)(perms%1000000007);
        
    }
    
    public boolean isPrime(int n) {
        
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}