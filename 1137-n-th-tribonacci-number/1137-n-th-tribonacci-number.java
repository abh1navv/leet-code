class Solution {
    public int tribonacci(int n) {
        int first = 0;
        int second = 1;
        int third = 1;
        int temp = 0;
        if(n<2) return n;
        
        for(int i=3; i<=n; i++) {
            temp = third+first+second;
            first = second;
            second = third;
            third = temp;
        }
        
        return third;
    }
}