class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        seen.add(1);
        
        int d=0,sum=0;
        
        while(seen.add(n)) {
            sum=0;
            while(n!=0) {
                d = n%10;
                sum+=d*d;
                n/=10;
            }
            n = sum;
        }
        
        return n==1;
    }
    
}