class Solution {
    public double myPow(double x, int n) {
        double ans;
        if(n>0) {
           ans = multiply(x,n);
        } else {
           ans = 1/multiply(x,Math.abs(n));
        }
        return ans;
    }
    
    public double multiply(double x, int n) {
        if(n==0) return 1.0;
        if(n==1) return x;
        double temp = multiply(x,n/2);
        if(n%2 == 0)
        { 
            return temp * temp;
        }
        else
        {
             return x * temp * temp;
        } 
    }
    
}