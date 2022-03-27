class Solution {
    public int countPrimes(int n) {
        boolean[] isNotPrime = new boolean[n];
        int count = 0;
        
        for(int i=2; i<n;i++) {
            if(!isNotPrime[i]) {
                count++;
                for(int j=2;i*j<n;j++) {
                    isNotPrime[i*j] = true;
                }
            }
        }
        return count;
    }
    
}