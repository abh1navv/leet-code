class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)) {
            set.add(n);
            int x = 0;
            while(n!=0) {
                int d=n%10;
                x+=d*d;
                n=n/10;
            }
            n=x;
        }
        return n==1;
    }
    
    
}