class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)) {
            set.add(n);
            n = updateN(n);
        }
        return n==1;
    }
    
    public int updateN(int n) {
        int x = 0;
        while(n!=0) {
            int d = n%10;
            x+=d*d;
            n=n/10;
        }
        return x;
    }
}