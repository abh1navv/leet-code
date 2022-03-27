class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        
        boolean[] isNotPrime = new boolean[n];
        updatePrimes(n, 2, isNotPrime);
        int count = 1;
        
        for(int i=3; i<n;i+=2) {
            if(!isNotPrime[i]) {
                count++;
                updatePrimes(n, i, isNotPrime);
            }
        }
        return count;
    }
    
    public void updatePrimes(int n, int i, boolean[] isNotPrime) {
        int j=2;
        while(i*j<n) {
            isNotPrime[i*j++] = true;
        }
    }
    
}