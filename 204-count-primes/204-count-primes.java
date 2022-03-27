class Solution {
    public int countPrimes(int n) {
        boolean[] isNotPrime = new boolean[n];
        int count = 0;
        
        for(int i=2; i<n;i++) {
            if(!isNotPrime[i]) {
                count++;
                int j=2;
                while(i*j<n) {
                    isNotPrime[i*j++] = true;
                }
            }
        }
        return count;
    }
    
}