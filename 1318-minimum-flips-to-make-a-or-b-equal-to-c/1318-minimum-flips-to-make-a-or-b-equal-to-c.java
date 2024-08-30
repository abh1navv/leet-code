class Solution {
    public int minFlips(int a, int b, int c) {
        int count=0;
        while(a!=0 || b!=0 || c!=0){
            if(c%2 == 0) {
                count+=b%2+a%2;
            } else if( a%2==0 && b%2==0) {
                count++;
            }
            
            a = a/2;
            b = b/2;
            c = c/2;
            
        }
        
        return count;
    }
}