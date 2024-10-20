class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while(n != 1) {
            if(!seen.add(n)) return false;
            n = updatedN(n);
        }
        
        return true;
    }
    
    int updatedN(int n) {
        int sum=0;
        while(n!=0) {
            int d = n%10;
            sum+=d*d;
            n/=10;
        }
        return sum;
    }
}